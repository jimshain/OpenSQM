package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

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
import com.opensqm.json.Choice;
import com.opensqm.json.Question;
import com.opensqm.json.QuestionAddRq;
import com.opensqm.json.QuestionAddRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Question add controller.
 *
 */
@Controller
public class QuestionAdd {

	/**
	 * Question add SQL
	 */
	private static final String QUESTION_ADD_SQL = "insert into QUIZ_QUESTION_TB values (?, ?, ?, ?)";
	
	/**
	 * Choice add SQL
	 */
	private static final String CHOICE_ADD_SQL = "insert into QUIZ_CHOICE_TB value (?, ?, ?, ?)";
	
	/**
	 * Question category add SQL
	 */
	private static final String QUESTION_CATEGORY_ADD_SQL = "insert into QUIZ_QUESTION_CATEGORY_TB values (?, ?)";

	/**
	 * Question add.
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "questionAdd", method = RequestMethod.POST)
	public @ResponseBody String doQuestionAdd(@RequestBody String request,
			ModelMap model) {
		Gson gson = new Gson();
		QuestionAddRq questionAddRq = null;
		QuestionAddRs questionAddRs = new QuestionAddRs();
		String response = null;
		Status status = new Status("999", "Status not set.");

		questionAddRs.setResponseHeader(new ResponseHeader());

		try {
			questionAddRq = gson.fromJson(request, QuestionAddRq.class);
			validate(questionAddRq);
			questionAddRs.setResponseHeader(new ResponseHeader());
			questionAddRs.getResponseHeader().setRquid(questionAddRq.getRequestHeader().getRquid());
			add(questionAddRq.getQuestion());
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}

		questionAddRs.setStatus(status);
		response = gson.toJson(questionAddRs);
		System.out.println("response = " + response);
		return response;
	}

	private void validate(QuestionAddRq questionAddRq) throws StatusException {
		if (questionAddRq == null) {
			throw new StatusException("105", "QuestionAddRq must not be null.");
		}
		if (questionAddRq.getRequestHeader() == null) {
			throw new StatusException("105", "QuestionAddRq.requestHeader must not be null");
		}
		if (questionAddRq.getQuestion() == null) {
			throw new StatusException("105",
					"QuestionAddRq.question must not be null.");
		}
		if (questionAddRq.getQuestion().getId() != null
				&& questionAddRq.getQuestion().getId().trim().length() != 0) {
			throw new StatusException("105",
					"QuestionAddRq.question.id must not be set.");
		}
		if (questionAddRq.getQuestion().getText() == null
				|| questionAddRq.getQuestion().getText().trim().length() == 0) {
			throw new StatusException("105",
					"QuestionAddRq.question.text must be set");
		}
	}

	private String add(Question question) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		String rquid = UUID.randomUUID().toString();
		Timestamp now = new Timestamp(Calendar.getInstance().getTime()
				.getTime());
		int choiceIndex = 0;

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();

			// Add the question
			pStmt = conn.prepareStatement(QUESTION_ADD_SQL);
			pStmt.setString(1, rquid);
			pStmt.setString(2, question.getText());
			pStmt.setBoolean(3, question.isActive());
			pStmt.setTimestamp(4, now);
			pStmt.execute();
			pStmt.close();

			// Add the choices
			if (question.getChoices() != null) {
				for (Choice choice : question.getChoices()) {
					pStmt = conn.prepareStatement(CHOICE_ADD_SQL);
					pStmt.setString(1, rquid);
					pStmt.setInt(2, ++choiceIndex);
					pStmt.setString(3, choice.getText());
					pStmt.setBoolean(4, choice.isCorrectAnswer());
					pStmt.close();
				}
			}

			// Add the categories
			if (question.getCategories() != null) {
				for (String category : question.getCategories()) {
					pStmt = conn.prepareStatement(QUESTION_CATEGORY_ADD_SQL);
					pStmt.setString(1, rquid);
					pStmt.setString(2, category);
					pStmt.execute();
					pStmt.close();
				}
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
		return rquid;
	}

}// Class end