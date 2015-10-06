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
import com.opensqm.json.CategoryAddRs;
import com.opensqm.json.CategoryDelRq;
import com.opensqm.json.RequestHeader;

public class CategoryDelTest {

	public static void main(String[] args) {

	}

	public void testValidCategory() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(
				"http://localhost:8080/OpenSQM-1.0/v1.0/categoryDel");
		CloseableHttpResponse response = null;
		String json = null;
		String request = null;
		RequestHeader requestHeader = new RequestHeader();
		CategoryDelRq categoryDelRq = new CategoryDelRq();
		Category category = new Category();
		String categoryId = null;
		try {
			categoryId = setUp();
			requestHeader.setRquid(UUID.randomUUID().toString());
			requestHeader.setUserId("56");
			category.setText("Why did the chicken cross the road?");
			categoryDelRq.setRequestHeader(requestHeader);
			categoryDelRq.setCategoryId(categoryId);
			request = gson.toJson(categoryDelRq);
			System.out.println("Request = " + request);
			httpPost.setEntity(new StringEntity(request));
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				json = EntityUtils.toString(response.getEntity());
				System.out.println("Respone = " + json);
			} else {
				System.out.println("HTTP Error: "
						+ response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String setUp() {
		Gson gson = new Gson();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(
				"http://localhost:8080/OpenSQM-1.0/v1.0/categoryAdd");
		CloseableHttpResponse response = null;
		String json = null;
		String request = null;
		RequestHeader requestHeader = new RequestHeader();
		CategoryAddRq categoryAddRq = new CategoryAddRq();
		CategoryAddRs categoryAddRs = null;
		Category category = new Category();
		String categoryId = null;
		try {
			requestHeader.setRquid(UUID.randomUUID().toString());
			requestHeader.setUserId("56");
			category.setText("Why did the chicken cross the road?");
			categoryAddRq.setRequestHeader(requestHeader);
			category.setText("Science");
			category.setWeight(23);
			categoryAddRq.setCategory(category);
			request = gson.toJson(categoryAddRq);
			System.out.println("Request = " + request);
			httpPost.setEntity(new StringEntity(request));
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				json = EntityUtils.toString(response.getEntity());
				System.out.println("Respone = " + json);
				categoryAddRs = gson.fromJson(json, CategoryAddRs.class);
				categoryId = categoryAddRs.getCategoryId();
			} else {
				System.out.println("HTTP Error: "
						+ response.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryId;
	}
}
