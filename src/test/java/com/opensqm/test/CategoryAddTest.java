package com.opensqm.test;

import java.util.UUID;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.opensqm.json.Category;
import com.opensqm.json.CategoryAddRq;
import com.opensqm.json.RequestHeader;

public class CategoryAddTest {

	public static void main(String [] args) {
		CategoryAddTest categoryAddTest = new CategoryAddTest();
		categoryAddTest.testValidCategory();
	}
	
	public void testValidCategory() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/OpenSQM-1.0/v1.0/categoryAdd");
		CloseableHttpResponse response = null;
		String json = null;
		String request = null;
		CategoryAddRq categoryAddRq = new CategoryAddRq();
		Category category = new Category();

		try {
			category.setText("English");
			category.setWeight(20);
			categoryAddRq.setRequestHeader(new RequestHeader());
			categoryAddRq.getRequestHeader().setRquid(UUID.randomUUID().toString());
			categoryAddRq.setCategory(category);
			request = gson.toJson(categoryAddRq);
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
