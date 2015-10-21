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
import com.opensqm.json.Choice;
import com.opensqm.json.Question;
import com.opensqm.json.QuestionInqRq;
import com.opensqm.json.QuestionInqRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Question inquiry message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class QuestionInq {

	private static final String SELECT_QUESTION_BY_QUESTION_ID = "select QUESTION_ID, QUESTION_TEXT, ACTIVE from QUIZ_QUESTION_TB where QUESTION_ID = ?";
	private static final String SELECT_ALL_QUESTIONS = "select QUESTION_ID, QUESTION_TEXT, ACTIVE from QUIZ_QUESTION_TB";

	private static final String SELECT_CHOICES_BY_QUESTION_ID = "select CHOICE_ID, CHOICE_TEXT, ANSWER from QUIZ_CHOICE_TB where QUESTION_ID = ?";
	private static final String SELECT_CATEGORY_BY_QUESTION_ID = "select CATEGORY_ID from QUIZ_QUESTION_CATEGORY_TB where QUESTION_ID = ?";
	private static final String SELECT_CATEGORY_BY_CATEGORY_ID = "select CATEGORY_TEXT from QUIZ_CATEGORY_TB where CATEGORY_ID = ?";

	/**
	 * Question inquiry.
	 * 
	 * @param request
	 *            Question inquiry request message.
	 * @return Question inquiry response message.
	 */
	@RequestMapping(value = "questionInq", method = RequestMethod.POST)
	public @ResponseBody String doQuestionInq(@RequestBody String request) {
		Gson gson = new Gson();
		QuestionInqRq questionInqRq = null;
		QuestionInqRs questionInqRs = new QuestionInqRs();
		Status status = new Status("999", "Status not set.");
		String json = null;

		try {
			questionInqRq = gson.fromJson(request, QuestionInqRq.class);
			questionInqRs.setResponseHeader(new ResponseHeader());
			questionInqRs.getResponseHeader().setRquid(
					questionInqRq.getRequestHeader().getRquid());
			questionInqRs.setQuestions(inq(questionInqRq.getQuestionId()));
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
		}

		questionInqRs.setStatus(status);
		json = gson.toJson(questionInqRs);
		return json;
	}

	/**
	 * Gets the questions.
	 * 
	 * @param questionId
	 *            Question ID.
	 * @return Array of questions.
	 * @throws StatusException
	 *             throws StatusException if there is a problem.
	 */
	private Question[] inq(String questionId) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		Question question = null;
		Question[] questions = null;
		List<Question> questionList = new ArrayList<Question>();
		ResultSet rs = null;
		Choice choice = null;
		Choice[] choices = null;
		List<Choice> choiceList = new ArrayList<Choice>();

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();
			if (questionId == null || questionId.trim().length() == 0) {
				pStmt = conn.prepareStatement(SELECT_ALL_QUESTIONS);
			} else {
				pStmt = conn.prepareStatement(SELECT_QUESTION_BY_QUESTION_ID);
				pStmt.setString(1, questionId);
			}
			rs = pStmt.executeQuery();
			while (rs.next()) {
				question = new Question();
				question.setId(rs.getString(1));
				question.setText(rs.getString(2));
				question.setActive(rs.getBoolean(3));
				questionList.add(question);
			}
			rs.close();
			pStmt.close();

			for (Question q : questionList) {
				pStmt = conn.prepareStatement(SELECT_CHOICES_BY_QUESTION_ID);
				pStmt.setString(1, q.getId());
				rs = pStmt.executeQuery();
				while (rs.next()) {
					choice = new Choice();
					choice.setId(rs.getString(1));
					choice.setText(rs.getString(2));
					choice.setCorrectAnswer(rs.getBoolean(3));
					choiceList.add(choice);
				}
				choices = new Choice[choiceList.size()];
				choices = choiceList.toArray(choices);
				q.setChoices(choices);
				rs.close();
				pStmt.close();

				pStmt = conn.prepareStatement(SELECT_CATEGORY_BY_QUESTION_ID);
				pStmt.setString(1, q.getCategoryId());
				rs = pStmt.executeQuery();
				if (rs.next()) {
					q.setCategoryId(rs.getString(1));
				}
				rs.close();
				pStmt.close();

				pStmt = conn.prepareStatement(SELECT_CATEGORY_BY_CATEGORY_ID);

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

		questions = new Question[questionList.size()];
		questions = questionList.toArray(questions);
		return questions;
	}

} // Class end