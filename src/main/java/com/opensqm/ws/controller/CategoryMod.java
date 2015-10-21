package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.Category;
import com.opensqm.json.CategoryModRq;
import com.opensqm.json.CategoryModRs;
import com.opensqm.json.Status;

/**
 * Category modify message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class CategoryMod {

	/**
	 * Update category SQL statement
	 */
	private static final String CATEGORY_UPDATE_SQL = "update QUIZ_CATEGORY_TB set CATEGORY_TEXT = ?, WEIGHT = ? where CATEGORY_ID = ?";

	/**
	 * Category modify
	 * 
	 * @param request
	 *            Category modify request message
	 * @return Category modify response message
	 */
	@RequestMapping(value = "categoryMod", method = RequestMethod.POST)
	public @ResponseBody String doCategoryMod(@RequestBody String request) {
		Gson gson = new Gson();
		CategoryModRq categoryModRq = null;
		CategoryModRs categoryModRs = new CategoryModRs();
		String response = null;
		Status status = new Status("999", "Status not set.");

		try {
			categoryModRq = gson.fromJson(request, CategoryModRq.class);
			validate(categoryModRq);
			mod(categoryModRq.getCategory());
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}
		categoryModRs.setStatus(status);
		response = gson.toJson(categoryModRs);
		System.out.println("response = " + response);
		return response;
	}

	/**
	 * Validates the category request message.
	 * 
	 * @param categoryModRq
	 *            Category modify request message
	 * @throws StatusException
	 *             Status exception thrown if validation fails.
	 */
	private void validate(CategoryModRq categoryModRq) throws StatusException {
		if (categoryModRq == null) {
			throw new StatusException("105", "CategoryModRq must not be null.");
		}
		if (categoryModRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"CategoryModRq.requestHeader must not be null");
		}
		if (categoryModRq.getCategory() == null) {
			throw new StatusException("105",
					"CategoryModRq.category must not be null");
		}
		if (categoryModRq.getCategory().getId() == null
				|| categoryModRq.getCategory().getId().trim().length() == 0) {
			throw new StatusException("105",
					"CategoryModRq.category.id must be set.");
		}
		if (categoryModRq.getCategory().getText() == null
				|| categoryModRq.getCategory().getText().trim().length() == 0) {
			throw new StatusException("105",
					"CategoryModRq.category.text must be set.");
		}
	}

	/**
	 * Modifies the category.
	 * 
	 * @param category
	 *            Category to modify.
	 * @return Category ID
	 * @throws StatusException
	 *             Throws a status exception if the insert fails.
	 */
	private String mod(Category category) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		String rquid = UUID.randomUUID().toString();

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();
			pStmt = conn.prepareStatement(CATEGORY_UPDATE_SQL);
			pStmt.setString(1, category.getText());
			pStmt.setInt(2, category.getWeight());
			pStmt.setString(3, category.getId());
			pStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new StatusException("800", e.toString());
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}

		return rquid;
	}
} // Class end
