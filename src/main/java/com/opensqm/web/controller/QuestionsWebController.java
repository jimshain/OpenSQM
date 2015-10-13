package com.opensqm.web.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.opensqm.json.Question;
import com.opensqm.json.QuestionAddRq;
import com.opensqm.json.QuestionAddRs;
import com.opensqm.json.QuestionDelRq;
import com.opensqm.json.QuestionDelRs;
import com.opensqm.json.QuestionInqRq;
import com.opensqm.json.QuestionInqRs;
import com.opensqm.json.QuestionModRq;
import com.opensqm.json.QuestionModRs;
import com.opensqm.json.RequestHeader;
import com.opensqm.json.Status;
import com.opensqm.web.json.QuestionAddForm;
import com.opensqm.web.json.QuestionDelForm;
import com.opensqm.web.json.QuestionInqForm;
import com.opensqm.web.json.QuestionModForm;

@Controller
public class QuestionsWebController {
	/**
	 * Question inquiry web service URL.
	 */
	// TODO: This is hard coded for now. Should come from a property file.
	private final static String QUESTION_INQ_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/questionInq";

	/**
	 * Question mod web service URL.
	 */
	// TODO: This is hard coded for now. Should come from a property file.
	private final static String QUESTION_MOD_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/questionMod";

	/**
	 * Question add web service URL.
	 */
	// TODO: This is hard coded for now. Should come from a property file.
	private final static String QUESTION_ADD_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/questionAdd";

	/**
	 * Question add web service URL.
	 */
	// TODO: This is hard coded for now. Should come from a property file.
	private final static String QUESTION_DEL_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/questionDel";

	@RequestMapping(value = "questions", method = RequestMethod.GET)
	public String getQuestions() {
		return "questions";
	}

	@RequestMapping(value = "questionInqWeb", method = RequestMethod.POST)
	public String questionInq(@RequestBody String request) {

		Gson gson = new Gson();
		QuestionInqForm questionInqForm = null;
		QuestionInqRq questionInqRq = new QuestionInqRq();
		QuestionInqRs questionInqRs = null;
		String json = null;

		try {
			questionInqForm = gson.fromJson(request, QuestionInqForm.class);
			questionInqRq.setRequestHeader(new RequestHeader());
			questionInqRq.setQuestionId(questionInqForm.getQuestionId());
			json = gson.toJson(questionInqRq);
			json = send(QUESTION_INQ_URL, json);
		} catch (Exception e) {
			e.printStackTrace();
			questionInqRs = new QuestionInqRs();
			questionInqRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(questionInqRs);
		}
		return json;
	}

	@RequestMapping(value = "questionModWeb", method = RequestMethod.POST)
	public String questionMod(@RequestBody String request) {

		Gson gson = new Gson();
		QuestionModForm questionModForm = null;
		QuestionModRq questionModRq = new QuestionModRq();
		QuestionModRs questionModRs = null;
		Question question = new Question();
		String json = null;

		try {
			questionModForm = gson.fromJson(request, QuestionModForm.class);
			questionModRq.setRequestHeader(new RequestHeader());
			question.setId(questionModForm.getQuestionId());
			question.setText(questionModForm.getText());
			// question.setChoices(questionModForm.getCategoryId());
			question.setCategoryId(questionModForm.getCategoryId());
			questionModRq.setQuestion(question);
			json = gson.toJson(questionModRq);
			json = send(QUESTION_MOD_URL, json);
		} catch (Exception e) {
			e.printStackTrace();
			questionModRs = new QuestionModRs();
			questionModRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(questionModRs);
		}
		return json;
	}

	@RequestMapping(value = "questionAddWeb", method = RequestMethod.POST)
	public String questionAdd(@RequestBody String request) {

		Gson gson = new Gson();
		QuestionAddForm questionAddForm = null;
		QuestionAddRq questionAddRq = new QuestionAddRq();
		QuestionAddRs questionAddRs = null;
		Question question = new Question();
		String json = null;

		try {
			questionAddForm = gson.fromJson(request, QuestionAddForm.class);
			questionAddRq.setRequestHeader(new RequestHeader());
			question.setText(questionAddForm.getText());
			// question.setChoices(questionModForm.getCategoryId());
			question.setCategoryId(questionAddForm.getCategoryId());
			questionAddRq.setQuestion(question);
			json = gson.toJson(questionAddRq);
			json = send(QUESTION_ADD_URL, json);
		} catch (Exception e) {
			e.printStackTrace();
			questionAddRs = new QuestionAddRs();
			questionAddRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(questionAddRs);
		}

		return json;
	}

	@RequestMapping(value = "questionDelWeb", method = RequestMethod.POST)
	public String questionDel(@RequestBody String request) {

		Gson gson = new Gson();
		QuestionDelForm questionDelForm = null;
		QuestionDelRq questionDelRq = new QuestionDelRq();
		QuestionDelRs questionDelRs = null;
		String json = null;

		try {
			questionDelForm = gson.fromJson(request, QuestionDelForm.class);
			questionDelRq.setRequestHeader(new RequestHeader());
			questionDelRq.setQuestionId(questionDelForm.getQuestionId());
			json = gson.toJson(questionDelRq);
			json = send(QUESTION_DEL_URL, json);
		} catch (Exception e) {
			e.printStackTrace();
			questionDelRs = new QuestionDelRs();
			questionDelRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(questionDelRs);
		}

		return json;
	}

	private String send(String url, String data) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		String json = null;

		System.out.println("Request = " + data);
		httpPost.setEntity(new StringEntity(data));
		response = httpclient.execute(httpPost);
		if (response.getStatusLine().getStatusCode() == 200) {
			json = EntityUtils.toString(response.getEntity());
			System.out.println("Respone = " + json);
		} else {
			System.out.println("HTTP Error: "
					+ response.getStatusLine().getStatusCode());
			throw new Exception(response.getStatusLine().toString());
		}

		return json;
	}

} // Class end