package com.opensqm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoriesWebController {

	
	@RequestMapping(value = "categories", method = RequestMethod.GET)
	public String getCategories() {
		return "categories";
	}

	
	@RequestMapping(value="categoriesInqWeb", method=RequestMethod.POST)
	public @ResponseBody String categoriesInq(@RequestBody String request) {
		String response = null;
		
		return response;
	}
}
