package com.opensqm.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.Question;
import com.opensqm.json.QuestionModRq;
import com.opensqm.json.QuestionModRs;
import com.opensqm.json.Status;

@Controller
public class QuestionMod {

	@RequestMapping(value = "questionMod", method = RequestMethod.POST)
	public @ResponseBody String doQuestionAdd(@RequestBody String request,
			ModelMap model) {
		Gson gson = new Gson();
		String response = null;
		QuestionModRq questionModRq = null;
		QuestionModRs questionModRs = new QuestionModRs();
		Status status = new Status("999", "Status not set.");
		String json = null;
		
		try {
			questionModRq = gson.fromJson(request, QuestionModRq.class);
			modify(questionModRq.getQuestion());
		} catch(StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}
		
		return json;
	}
	
	private void modify(Question question) throws StatusException {
		
	}
} // Class end