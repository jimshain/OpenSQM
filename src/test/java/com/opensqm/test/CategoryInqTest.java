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
import com.opensqm.json.RequestHeader;

public class CategoryInqTest {

	public static void main(String[] args) {

		CategoryInqTest categoryInqTest = new CategoryInqTest();
		categoryInqTest.testValidInquiry();
	}

	public void testValidInquiry() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/OpenSQM-1.0/v1.0/categoryInq");
		CloseableHttpResponse response = null;
		String request = null;
		String json = null;

		CategoryInqRq categoryInqRq = new CategoryInqRq();
		
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
			} else {
				System.out.println("HTTP Error: " + response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
