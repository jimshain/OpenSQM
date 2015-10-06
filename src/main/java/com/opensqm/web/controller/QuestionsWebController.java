package com.opensqm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionsWebController {

	@RequestMapping(value = "questions", method = RequestMethod.GET)
	public String getQuestions() {
		return "questions";
	}	
}
