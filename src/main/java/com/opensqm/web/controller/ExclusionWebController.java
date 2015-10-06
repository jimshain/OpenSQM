package com.opensqm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExclusionWebController {

	@RequestMapping(value = "exclusions", method = RequestMethod.GET)
	public String getExclusions() {
		return "exclusions";
	}	
}
