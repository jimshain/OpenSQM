package com.opensqm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class MainMenuWebController {
	
	@RequestMapping(value = "mainMenu", method = RequestMethod.GET)
	public String getMainMenu() {
		return "mainMenu";
	}

	/**
	@RequestMapping(value="testQuestionInq", method=RequestMethod.POST)
	public @ResponseBody String testQuestionInq(@RequestBody String request) {
		String response = null;
		Gson gson = new Gson();
		
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	*/
}
