package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.Exclusion;
import com.opensqm.json.ExclusionAddRq;
import com.opensqm.json.ExclusionAddRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Exclusion add message handler.
 * 
 * @author Jim Shain
 *
 */
public class ExclusionAdd {

	/**
	 * Exclusion add SQL.
	 */
	private static final String EXCLUSION_ADD_SQL = "insert into QUIZ_EXCLUSION_TB values (?, ?, ?, ?, ?, ?)";

	/**
	 * Exclusion add.
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "exclusionAdd", method = RequestMethod.POST)
	public @ResponseBody String doExclusionAdd(@RequestBody String request) {
		Gson gson = new Gson();
		ExclusionAddRq exclusionAddRq = null;
		ExclusionAddRs exclusionAddRs = new ExclusionAddRs();
		String response = null;
		Status status = new Status("999", "Status not set.");
		try {
			exclusionAddRq = gson.fromJson(request, ExclusionAddRq.class);
			validate(exclusionAddRq);
			exclusionAddRs.setResponseHeader(new ResponseHeader());
			exclusionAddRs.getResponseHeader().setRquid(
					exclusionAddRq.getRequestHeader().getRquid());
			exclusionAddRs.setExclusionId(add(exclusionAddRq.getExclusion()));
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}

		exclusionAddRs.setStatus(status);
		response = gson.toJson(exclusionAddRs);
		System.out.println("response = " + response);

		return response;
	}

	/**
	 * Validate the exclusion add request.
	 * 
	 * @param exclusionAddRq
	 *            Exclusion add request
	 * @throws StatusException
	 *             Throws a status exception if validation fails.
	 */
	private void validate(ExclusionAddRq exclusionAddRq) throws StatusException {
		if (exclusionAddRq == null) {
			throw new StatusException("105", "ExclusionAddRq must not be null.");
		}
		if (exclusionAddRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"ExclusionAddRq.requestHeader must not be null");
		}
		if (exclusionAddRq.getExclusion() == null) {
			throw new StatusException("105",
					"ExclusionAddRq.exclusion must not be null.");
		}
		if (exclusionAddRq.getExclusion().getId() != null
				&& exclusionAddRq.getExclusion().getId().trim().length() != 0) {
			throw new StatusException("105",
					"ExclusionAddRq.exclusion.id must not be set.");
		}
	}

	/**
	 * Add a exclusion to the database.
	 * 
	 * @param exclusion
	 *            Exclusion
	 * @return Exclusion ID
	 * @throws StatusException
	 *             Throws a status exception if insert fails.
	 */
	private String add(Exclusion exclusion) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		String rquid = UUID.randomUUID().toString();
		Timestamp now = new Timestamp(Calendar.getInstance().getTime()
				.getTime());
		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();

			// Add the question
			pStmt = conn.prepareStatement(EXCLUSION_ADD_SQL);
			pStmt.setString(1, rquid);
			pStmt.setString(2, exclusion.getType());
			pStmt.setString(3, exclusion.getValue());
			pStmt.setString(4, exclusion.getStartTime());
			pStmt.setString(5, exclusion.getEndTime());
			pStmt.setTimestamp(6, now);
			pStmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
			throw new StatusException("800", e.toString());
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
		return rquid;
	}

} // Class end