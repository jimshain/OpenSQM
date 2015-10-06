package com.opensqm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportsWebController {

	@RequestMapping(value = "reports", method = RequestMethod.GET)
	public String getMainMenu() {
		return "reports";
	}

} // Class end