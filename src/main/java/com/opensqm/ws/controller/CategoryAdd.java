package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.Category;
import com.opensqm.json.CategoryAddRq;
import com.opensqm.json.CategoryAddRs;
import com.opensqm.json.Status;

/**
 * Category add message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class CategoryAdd {

	/**
	 * Insert category SQL statement
	 */
	private static final String CATEGORY_INSERT_SQL = "insert into QUIZ_CATEGORY_TB values (?, ?, ?, ?)";

	/**
	 * Category add
	 * 
	 * @param request
	 *            Category add request message.
	 * @return Category add response message.
	 */
	@RequestMapping(value = "categoryAdd", method = RequestMethod.POST)
	public @ResponseBody String doCategoryAdd(@RequestBody String request) {
		Gson gson = new Gson();
		CategoryAddRq categoryAddRq = null;
		CategoryAddRs categoryAddRs = new CategoryAddRs();
		String response = null;
		Status status = new Status("999", "Status not set.");

		try {
			categoryAddRq = gson.fromJson(request, CategoryAddRq.class);
			validate(categoryAddRq);
			categoryAddRs.setCategoryId(add(categoryAddRq.getCategory()));
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}
		categoryAddRs.setStatus(status);
		response = gson.toJson(categoryAddRs);
		System.out.println("response = " + response);
		return response;
	}

	/**
	 * Validates the category request message.
	 * 
	 * @param categoryAddRq
	 *            Category add request message
	 * @throws StatusException
	 *             Status exception thrown if validation fails.
	 */
	private void validate(CategoryAddRq categoryAddRq) throws StatusException {
		if (categoryAddRq == null) {
			throw new StatusException("105", "CategoryAddRq must not be null.");
		}
		if (categoryAddRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"CategoryAddRq.requestHeader must not be null");
		}
		if (categoryAddRq.getCategory() == null) {
			throw new StatusException("105",
					"CategoryAddRq.category must not be null");
		}
		if (categoryAddRq.getCategory().getId() != null
				&& categoryAddRq.getCategory().getId().trim().length() > 0) {
			throw new StatusException("105",
					"CategoryAddRq.category.id must not be set.");
		}
		if (categoryAddRq.getCategory().getText() == null
				|| categoryAddRq.getCategory().getText().trim().length() == 0) {
			throw new StatusException("105",
					"CategoryAddRq.category.text must be set.");
		}
	}

	/**
	 * Adds the category.
	 * 
	 * @param category
	 *            Category to add.
	 * @return Category ID
	 * @throws StatusException
	 *             Throws a status exception if the insert fails.
	 */
	private String add(Category category) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		String rquid = UUID.randomUUID().toString();
		Timestamp now = new Timestamp(Calendar.getInstance().getTime()
				.getTime());

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();
			pStmt = conn.prepareStatement(CATEGORY_INSERT_SQL);
			pStmt.setString(1, rquid);
			pStmt.setString(2, category.getText());
			pStmt.setInt(3, category.getWeight());
			pStmt.setTimestamp(4, now);
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