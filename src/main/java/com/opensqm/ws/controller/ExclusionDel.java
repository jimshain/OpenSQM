package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.ExclusionDelRq;
import com.opensqm.json.ExclusionDelRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Exclusion delete message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class ExclusionDel {

	/**
	 * Exclusion delete SQL.
	 */
	private static final String EXCLUSION_DELETE_SQL = "delete from QUIZ_EXCLUSION_TB where EXCLUSION_ID = ?";

	/**
	 * Exclusion delete.
	 * 
	 * @param request
	 *            Exclusion delete request message.
	 * @return Exclusion delete response message.
	 */
	@RequestMapping(value = "exclusionDel", method = RequestMethod.POST)
	public @ResponseBody String exclusionDel(@RequestBody String request) {
		Gson gson = new Gson();
		ExclusionDelRq exclusionDelRq = null;
		ExclusionDelRs exclusionDelRs = new ExclusionDelRs();
		Status status = new Status("999", "Status not set.");
		try {
			exclusionDelRq = gson.fromJson(request, ExclusionDelRq.class);
			validate(exclusionDelRq);
			exclusionDelRs.setResponseHeader(new ResponseHeader());
			exclusionDelRs.getResponseHeader().setRquid(
					exclusionDelRq.getRequestHeader().getRquid());
			delete(exclusionDelRq.getExclusionId());
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}
		exclusionDelRs.setStatus(status);
		return null;
	}

	/**
	 * Validate the exclusion delete request.
	 * 
	 * @param exclusionDelRq
	 *            Exclusion delete request.
	 * @throws StatusException
	 *             Throws a status exception if validation fails.
	 */
	private void validate(ExclusionDelRq exclusionDelRq) throws StatusException {
		if (exclusionDelRq == null) {
			throw new StatusException("105", "ExclusionDelRq must not be null.");
		}
		if (exclusionDelRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"ExclusionDelRq.requestHeader must not be null");
		}
		if (exclusionDelRq.getExclusionId() == null) {
			throw new StatusException("105",
					"ExclusionDelRq.exclusionId must not be null.");
		}
	}

	/**
	 * Deletes an exclusion to the database.
	 * 
	 * @param id
	 *            Exclusion ID
	 * @throws StatusException
	 *             Throws a status exception if the delete fails.
	 */
	private void delete(String id) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();

			// Add the question
			pStmt = conn.prepareStatement(EXCLUSION_DELETE_SQL);
			pStmt.setString(1, id);
			pStmt.executeUpdate();
			pStmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new StatusException("800", e.toString());
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}

} // Class end