package com.opensqm.test;

import java.util.UUID;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.opensqm.json.CategoryInqRq;
import com.opensqm.json.CategoryInqRs;
import com.opensqm.json.Choice;
import com.opensqm.json.Question;
import com.opensqm.json.QuestionAddRq;
import com.opensqm.json.QuestionAddRs;
import com.opensqm.json.QuestionDelRq;
import com.opensqm.json.RequestHeader;

public class QuestionAddTest {

	private String categoryId;
	private String questionId;
	
	public static void main(String[] args) {
		
		QuestionAddTest questionAddTest = new QuestionAddTest();
		questionAddTest.setup();
		questionAddTest.testValidQuestion();
		questionAddTest.cleanup();

	}

	public void setup() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/OpenSQM-1.0/v1.0/categoryInq");
		CloseableHttpResponse response = null;
		String request = null;
		String json = null;

		CategoryInqRq categoryInqRq = new CategoryInqRq();
		CategoryInqRs categoryInqRs = null;
		
		try {
			categoryInqRq.setRequestHeader(new RequestHeader());
			categoryInqRq.getRequestHeader().setRquid(UUID.randomUUID().toString());
			request = gson.toJson(categoryInqRq);
			System.out.println("Request = " + request);
			httpPost.setEntity(new StringEntity(request));
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				json = EntityUtils.toString(response.getEntity());
				System.out.println("Respone = " + json);
				categoryInqRs = gson.fromJson(json, CategoryInqRs.class);
				categoryId = categoryInqRs.getCategories()[0].getId();
			} else {
				System.out.println("HTTP Error: " + response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testValidQuestion() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/OpenSQM-1.0/v1.0/questionAdd");
		CloseableHttpResponse response = null;
		String json = null;
		String request = null;
		QuestionAddRq questionAddRq = new QuestionAddRq();
		QuestionAddRs questionAddRs = null;
		RequestHeader requestHeader = new RequestHeader();
		Question question = new Question();
		Choice choice = new Choice();
		Choice [] choices = new Choice[3];
		
		try {
			requestHeader.setRquid(UUID.randomUUID().toString());
			requestHeader.setUserId("56");
			question.setText("Why did the chicken cross the road?");
			
			questionAddRq.setRequestHeader(requestHeader);
			
			questionAddRq.setQuestion(question);
			
			choice.setText("To get to the other side.");
			choice.setCorrectAnswer(false);
			choices[0] = choice;
			choice = new Choice();
			choice.setText("Because Colonel Sander's was behind him.");
			choice.setCorrectAnswer(false);
			choices[1] = choice;
			choice = new Choice();
			choice.setText("He didn't. Nuggets anyone!");
			choice.setCorrectAnswer(true);
			choices[2] = choice;
			
			questionAddRq.getQuestion().setChoices(choices);
			
			questionAddRq.getQuestion().setCategoryId(categoryId);
			
			request = gson.toJson(questionAddRq);
			System.out.println("Request = " + request);
			httpPost.setEntity(new StringEntity(request));
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				json = EntityUtils.toString(response.getEntity());
				System.out.println("Respone = " + json);
				questionAddRs = gson.fromJson(json, QuestionAddRs.class);
				questionId = questionAddRs.getQuestionId();
			} else {
				System.out.println("HTTP Error: " + response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cleanup() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/OpenSQM-1.0/v1.0/questionDel");
		CloseableHttpResponse response = null;
		String json = null;
		String request = null;
		QuestionDelRq questionDelRq = new QuestionDelRq();
		questionDelRq.setQuestionId(questionId);
	}
} // Class end