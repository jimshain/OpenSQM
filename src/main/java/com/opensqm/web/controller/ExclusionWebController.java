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
import com.opensqm.json.Exclusion;
import com.opensqm.json.ExclusionAddRq;
import com.opensqm.json.ExclusionAddRs;
import com.opensqm.json.ExclusionDelRq;
import com.opensqm.json.ExclusionDelRs;
import com.opensqm.json.ExclusionListInqRq;
import com.opensqm.json.ExclusionListInqRs;
import com.opensqm.json.RequestHeader;
import com.opensqm.json.Status;
import com.opensqm.web.json.ExclusionAddForm;
import com.opensqm.web.json.ExclusionDelForm;

/**
 * Web controller to handle the exclusion page.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class ExclusionWebController {

	/**
	 * Exclusion list inquiry web service URL.
	 */
	// TODO: This is hard coded for now. Should come from a property file.
	private final static String EXCLUSION_LIST_INQ_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/exclusionListInq";

	/**
	 * Exclusion add web service URL.
	 */
	// TODO: This is hard coded for now. Should come from a property file.
	private final static String EXCLUSION_ADD_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/exclusionAdd";

	/**
	 * Exclusion delete web service URL.
	 */
	// TODO: This is hard coded for now. Should come from a property file.
	private final static String EXCLUSION_DEL_URL = "http://localhost:8080/OpenSQM-1.0/v1.0/exclusionDel";

	/**
	 * Process the web page get.
	 * 
	 * @return
	 */
	@RequestMapping(value = "exclusions", method = RequestMethod.GET)
	public String getExclusions() {
		return "exclusions";
	}

	/**
	 * Process the exclusion list inquiry request.
	 * 
	 * @param request
	 *            JSON request string.
	 * @return JSON response string.
	 */
	@RequestMapping(value = "exclusionListInqWeb", method = RequestMethod.POST)
	public @ResponseBody String doExclusionListInq(@RequestBody String request) {
		Gson gson = new Gson();
		String json = null;
		ExclusionListInqRq exclusionListInqRq = new ExclusionListInqRq();
		ExclusionListInqRs exclusionListInqRs = null;

		try {
			exclusionListInqRq.setRequestHeader(new RequestHeader());
			exclusionListInqRq.getRequestHeader().setRquid(
					UUID.randomUUID().toString());
			json = gson.toJson(exclusionListInqRq);
			json = send(EXCLUSION_LIST_INQ_URL, json);
		} catch (Exception e) {
			e.printStackTrace();
			exclusionListInqRs = new ExclusionListInqRs();
			exclusionListInqRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(exclusionListInqRs);
		}
		return json;
	}

	/**
	 * Process the exclusion add request.
	 * 
	 * @param request
	 *            JSON request string.
	 * @return JSON response string.
	 */
	@RequestMapping(value = "exclusionAddWeb", method = RequestMethod.POST)
	public @ResponseBody String doExclusionAdd(@RequestBody String request) {
		Gson gson = new Gson();
		String json = null;
		ExclusionAddRq exclusionAddRq = new ExclusionAddRq();
		ExclusionAddRs exclusionAddRs = null;
		ExclusionAddForm exclusionAddForm = null;

		try {
			exclusionAddForm = gson.fromJson(request, ExclusionAddForm.class);
			exclusionAddRq.setRequestHeader(new RequestHeader());
			exclusionAddRq.getRequestHeader().setRquid(
					UUID.randomUUID().toString());
			exclusionAddRq.setExclusion(new Exclusion());
			exclusionAddRq.getExclusion().setType(
					exclusionAddForm.getExclusionValue());
			exclusionAddRq.getExclusion().setValue(
					exclusionAddForm.getExclusionValue());
			exclusionAddRq.getExclusion().setStartTime(
					exclusionAddForm.getStartTime());

			json = gson.toJson(exclusionAddRq);
			json = send(EXCLUSION_ADD_URL, json);
		} catch (Exception e) {
			e.printStackTrace();
			exclusionAddRs = new ExclusionAddRs();
			exclusionAddRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(exclusionAddRs);
		}
		return json;
	}

	/**
	 * Process the exclusion delete request.
	 * 
	 * @param request
	 *            JSON request string.
	 * @return JSON response string.
	 */
	@RequestMapping(value = "ExclusionDelWeb", method = RequestMethod.POST)
	public @ResponseBody String doExclusionDel(@RequestBody String request) {
		Gson gson = new Gson();
		String json = null;
		ExclusionDelRq exclusionDelRq = new ExclusionDelRq();
		ExclusionDelRs exclusionDelRs = null;
		ExclusionDelForm exclusionDelForm = null;

		try {
			exclusionDelForm = gson.fromJson(request, ExclusionDelForm.class);
			exclusionDelRq.setRequestHeader(new RequestHeader());
			exclusionDelRq.getRequestHeader().setRquid(
					UUID.randomUUID().toString());
			exclusionDelRq.setExclusionId(exclusionDelForm.getExclusionId());
			json = gson.toJson(exclusionDelRq);
			json = send(EXCLUSION_DEL_URL, json);
		} catch (Exception e) {
			e.printStackTrace();
			exclusionDelRs = new ExclusionDelRs();
			exclusionDelRs.setStatus(new Status("999", e.toString()));
			json = gson.toJson(exclusionDelRs);
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
			System.err.println("HTTP Error: "
					+ response.getStatusLine().getStatusCode());
			throw new Exception(response.getStatusLine().toString());
		}

		return json;
	}

} // Class end