package com.opensqm.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.Question;
import com.opensqm.json.QuestionModRq;
import com.opensqm.json.QuestionModRs;
import com.opensqm.json.Status;

/**
 * Question modify handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class QuestionMod {

	/**
	 * Question modify
	 * 
	 * @param request
	 *            Question modify request message.
	 * @return Question modify response message.
	 */
	@RequestMapping(value = "questionMod", method = RequestMethod.POST)
	public @ResponseBody String doQuestionAdd(@RequestBody String request) {
		Gson gson = new Gson();
		String response = null;
		QuestionModRq questionModRq = null;
		QuestionModRs questionModRs = new QuestionModRs();
		Status status = new Status("999", "Status not set.");

		try {
			questionModRq = gson.fromJson(request, QuestionModRq.class);
			validate(questionModRq);
			modify(questionModRq.getQuestion());
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}
		questionModRs.setStatus(status);
		response = gson.toJson(questionModRs);
		return response;
	}

	private void validate(QuestionModRq questionModRq) throws StatusException {
		if (questionModRq == null) {
			throw new StatusException("105", "QuestionModRq must not be null.");
		}
	}

	private void modify(Question question) throws StatusException {

	}
} // Class end