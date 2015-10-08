package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.Question;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;
import com.opensqm.json.TestQuestionInqRq;
import com.opensqm.json.TestQuestionInqRs;

/**
 * Test question inquiry message handler.
 * @author Jim Shain
 *
 */
@Controller
public class TestQuestionInq {

	private static final String QUESTION_SELECT_SQL = "select QUESTION_ID, QUESTION_TEXT from QUIZ_QUESTION_TB";

	@RequestMapping(value = "testQuestionInq", method = RequestMethod.POST)
	public @ResponseBody String doTestQuestionInq(@RequestBody String request,
			ModelMap model) {
		
		Gson gson = new Gson();
		TestQuestionInqRq testQuestionInqRq = null;
		TestQuestionInqRs testQuestionInqRs = new TestQuestionInqRs();
		String response = null;
		Status status = new Status("999", "Status not set.");
		Question question = null;

		try {
			testQuestionInqRq = gson.fromJson(request, TestQuestionInqRq.class);
			validate(testQuestionInqRq);
			testQuestionInqRs.setResponseHeader(new ResponseHeader());
			testQuestionInqRs.getResponseHeader().setRquid(testQuestionInqRq.getRequestHeader().getRquid());
			question = inq(testQuestionInqRq.getRequestHeader().getUserId());
			testQuestionInqRs.setQuestion(question);
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}
		
		testQuestionInqRs.setStatus(status);
		response = gson.toJson(testQuestionInqRs);
		return response;
	}	
	
	private void validate(TestQuestionInqRq testQuestionInqRq) throws StatusException {
		if (testQuestionInqRq == null) {
			throw new StatusException("105", "TestQuestionInqRq must not be null.");
		}
		if (testQuestionInqRq.getRequestHeader() == null) {
			throw new StatusException("105", "TestQuestionInqRq.requestHeader must not be null.");
		}
	}
	
	private Question inq(String userId) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Question question = null;
		
		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();
			pStmt = conn.prepareStatement(QUESTION_SELECT_SQL);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				
			}
			pStmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new StatusException("800", e.toString());
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}		return question;
	}
	
} // Class end