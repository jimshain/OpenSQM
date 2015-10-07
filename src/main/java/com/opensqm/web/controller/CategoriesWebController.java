package com.opensqm.web.controller;

import java.util.UUID;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.CategoryInqRq;
import com.opensqm.json.CategoryInqRs;
import com.opensqm.json.RequestHeader;
import com.opensqm.json.Status;

@Controller
public class CategoriesWebController {

	private final static String CATEGORY_INQ_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/categoryInq";

	@RequestMapping(value = "categories", method = RequestMethod.GET)
	public String getCategories() {
		return "categories";
	}

	@RequestMapping(value = "categoryInqWeb", method = RequestMethod.POST)
	public @ResponseBody String categoryInq(@RequestBody String request) {
		Gson gson = new Gson();
		CategoryInqRq categoryInqRq = new CategoryInqRq();
		CategoryInqRs categoryInqRs = null;
		String json = null;

		categoryInqRq.setRequestHeader(new RequestHeader());
		categoryInqRq.getRequestHeader().setRquid(UUID.randomUUID().toString());
		try {
			request = gson.toJson(categoryInqRq);
			json = send(CATEGORY_INQ_URL, request);
		} catch (Exception e) {
			e.printStackTrace();
			categoryInqRs = new CategoryInqRs();
			categoryInqRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(categoryInqRs);
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
