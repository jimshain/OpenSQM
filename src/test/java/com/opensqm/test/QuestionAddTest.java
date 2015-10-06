package com.opensqm.test;

import java.util.UUID;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.opensqm.json.Question;
import com.opensqm.json.QuestionAddRq;
import com.opensqm.json.RequestHeader;

public class QuestionAddTest {

	public static void main(String[] args) {
		
		QuestionAddTest questionAddTest = new QuestionAddTest();
		questionAddTest.testValidQuestion();

	}

	public void testValidQuestion() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/OpenSQM-1.0/v1.0/questionAdd");
		CloseableHttpResponse response = null;
		String json = null;
		String request = null;
		QuestionAddRq questionAddRq = new QuestionAddRq();
		RequestHeader requestHeader = new RequestHeader();
		Question question = new Question();
		
		try {
			requestHeader.setRquid(UUID.randomUUID().toString());
			requestHeader.setUserId("56");
			question.setText("Why did the chicken cross the road?");
			questionAddRq.setRequestHeader(requestHeader);
			questionAddRq.setQuestion(question);
			request = gson.toJson(questionAddRq);
			System.out.println("Request = " + request);
			httpPost.setEntity(new StringEntity(request));
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				json = EntityUtils.toString(response.getEntity());
				System.out.println("Respone = " + json);
			} else {
				System.out.println("HTTP Error: " + response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
