package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.Exclusion;
import com.opensqm.json.ExclusionListInqRq;
import com.opensqm.json.ExclusionListInqRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Exclusion list inquiry message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class ExclusionListInq {

	/**
	 * Exclusion select SQL.
	 */
	private final static String EXCLUSION_SELECT_SQL = "select EXCLUSION_ID, EXCLUSION_TYPE, EXCLUSION_VALUE, START_TIME, END_TIME from QUIZ_EXCLUSION_TB";

	/**
	 * Exclusion list inquiry.
	 * 
	 * @param request
	 *            Exclusion list inquiry request message.
	 * @return Exclusion list inquiry response message.
	 */
	@RequestMapping(value = "exclusionListInq", method = RequestMethod.POST)
	public @ResponseBody String doExclusionListInq(@RequestBody String request) {
		Gson gson = new Gson();
		String response = null;
		Status status = new Status("999", "Status not set.");
		ExclusionListInqRq exclusionListInqRq = null;
		ExclusionListInqRs exclusionListInqRs = new ExclusionListInqRs();
		try {
			exclusionListInqRq = gson.fromJson(request,
					ExclusionListInqRq.class);
			validate(exclusionListInqRq);
			exclusionListInqRs.setResponseHeader(new ResponseHeader());
			exclusionListInqRs.getResponseHeader().setRquid(
					exclusionListInqRq.getRequestHeader().getRquid());
			exclusionListInqRs.setExclusions(inq());
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}

		exclusionListInqRs.setStatus(status);
		response = gson.toJson(exclusionListInqRs);

		return response;
	}

	/**
	 * Validate the exclusion list inquiry request.
	 * 
	 * @param exclusionListInqRq
	 *            Exclusion list inquiry request message.
	 * @throws StatusException
	 *             Throws a status exception if validation fails.
	 */
	private void validate(ExclusionListInqRq exclusionListInqRq)
			throws StatusException {
		if (exclusionListInqRq == null) {
			throw new StatusException("105",
					"ExclusionListInqRq must not be null.");
		}
		if (exclusionListInqRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"ExclusionListInqRq.requestHeader must not be null");
		}
	}

	/**
	 * Retrieve a list of exclusions from the database.
	 * 
	 * @return Exclusion list
	 * @throws StatusException
	 *             Throws a status exception if there is a failure.
	 */
	private Exclusion[] inq() throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Exclusion[] exclusions = null;
		Exclusion exclusion = null;
		List<Exclusion> exclusionList = new ArrayList<Exclusion>();

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();

			pStmt = conn.prepareStatement(EXCLUSION_SELECT_SQL);

			rs = pStmt.executeQuery();

			while (rs.next()) {
				exclusion = new Exclusion();
				exclusion.setId(rs.getString(1));
				exclusion.setType(rs.getString(2));
				exclusion.setValue(rs.getString(3));
				exclusion.setStartTime(rs.getString(4));
				exclusion.setEndTime(rs.getString(5));

				exclusionList.add(exclusion);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new StatusException("800", e.toString());
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}

		exclusions = new Exclusion[exclusionList.size()];
		exclusionList.toArray(exclusions);

		return exclusions;

	}

} // Class end