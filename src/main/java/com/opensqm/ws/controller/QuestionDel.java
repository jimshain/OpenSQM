package com.opensqm.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class QuestionDel {

	@RequestMapping(value = "questionDel", method = RequestMethod.POST)
	public @ResponseBody String doQuestionAdd(@RequestBody String request,
			ModelMap model) {
		Gson gson = new Gson();
		String response = null;
		String json = null;

		try {

		} catch (Exception e) {

		}

		return json;
	}
}
