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
import com.opensqm.json.QuestionDelRq;
import com.opensqm.json.QuestionDelRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Question delete message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class QuestionDel {

	/**
	 * Select the responses for a question ID SQL
	 */
	public static final String SELECT_RESPONSES_BY_QUESTION_ID = "select count(*) from QUIZ_RESPONSE_TB where QUESTION_ID = ?";

	/**
	 * Deletes choices for a question SQL
	 */
	public static final String DELETE_CHOICES_BY_QUESTION_ID = "delete from QUIZ_CHOICE_TB where QUESTION_ID = ?";

	/**
	 * Deletes the question/category relationship SQL
	 */
	public static final String DELETE_QUESTION_CATEGORY_RELATIONSHIP = "delete from QUIZ_QUESTION_CATEGORY_TB where QUESTION_ID = ?";

	/**
	 * Deletes the question SQL
	 */
	public static final String DELETE_QUESTION = "delete from QUIZ_QUESTION_TB where QUESTION_ID = ?";

	/**
	 * Deletes a question.
	 * @param request Question delete request message
	 * @param model
	 * @return Question delete response message.
	 */
	@RequestMapping(value = "questionDel", method = RequestMethod.POST)
	public @ResponseBody String doQuestionAdd(@RequestBody String request,
			ModelMap model) {
		Gson gson = new Gson();
		QuestionDelRq questionDelRq = null;
		QuestionDelRs questionDelRs = new QuestionDelRs();
		String response = null;
		Status status = new Status("999", "Status not set.");

		try {
			questionDelRs.setResponseHeader(new ResponseHeader());
			questionDelRq = gson.fromJson(request, QuestionDelRq.class);
			questionDelRs.getResponseHeader().setRquid(
					questionDelRq.getRequestHeader().getRquid());
			validate(questionDelRq);
			delete(questionDelRq.getQuestionId());
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {

		}

		questionDelRs.setStatus(status);
		response = gson.toJson(questionDelRs);
		return response;
	}

	/**
	 * Validates the question delete request.
	 * 
	 * @param questionDelRq
	 *            Question delete request
	 * @throws StatusException
	 *             Throws a status exception if validation fails.
	 */
	private void validate(QuestionDelRq questionDelRq) throws StatusException {
		if (questionDelRq == null) {
			throw new StatusException("105", "QuesitonDelRq must not be null.");
		}
		if (questionDelRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"QuestionDelRq.requestHeader must not be null.");
		}
		if (questionDelRq.getQuestionId() == null
				|| questionDelRq.getQuestionId().trim().length() == 0) {
			throw new StatusException("105",
					"QuestionDelRq.questionId must not be null.");
		}
	}

	/**
	 * Deletes the question and all child entries if the question has never been
	 * used.
	 * 
	 * @param questionId
	 *            Question ID
	 * @throws StatusException
	 *             Throws a status exception if there the delete fails.
	 */
	private void delete(String questionId) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int responseCount = 0;

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();
			conn.setAutoCommit(false);

			// Check to see if the question has been used.
			pStmt = conn.prepareStatement(SELECT_RESPONSES_BY_QUESTION_ID);
			pStmt.setString(1, questionId);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				responseCount = rs.getInt(1);
				if (responseCount > 0) {
					throw new StatusException(
							"105",
							"Unable to delete questions that have responses. Please deactive the question instead.");
				}
			}
			rs.close();

			// Delete the choices.
			pStmt = conn.prepareStatement(DELETE_CHOICES_BY_QUESTION_ID);
			pStmt.setString(1, questionId);
			pStmt.executeUpdate();
			pStmt.close();

			// Delete the category/question relationship.
			pStmt = conn
					.prepareStatement(DELETE_QUESTION_CATEGORY_RELATIONSHIP);
			pStmt.setString(1, questionId);
			pStmt.executeUpdate();
			pStmt.close();

			// Delete the question.
			pStmt = conn.prepareStatement(DELETE_QUESTION);
			pStmt.setString(1, questionId);
			pStmt.executeUpdate();
			pStmt.close();

			conn.commit();

		} catch (StatusException se) {
			throw se;
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