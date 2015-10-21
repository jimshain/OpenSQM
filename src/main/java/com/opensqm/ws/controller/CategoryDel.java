package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.opensqm.json.CategoryDelRq;
import com.opensqm.json.CategoryDelRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Category delete message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class CategoryDel {

	/**
	 * Category delete SQL.
	 */
	private static final String CATEGORY_DELETE_BY_ID_SQL = "delete from QUIZ_CATEGORY_TB where CATEGORY_ID = ?";

	/**
	 * Category delete.
	 * 
	 * @param request
	 *            Category delete request message.
	 * @return Category delete response message.
	 */
	@RequestMapping(value = "categoryDel", method = RequestMethod.POST)
	public @ResponseBody String doCategoryDel(@RequestBody String request) {
		Gson gson = new Gson();
		CategoryDelRq categoryDelRq = null;
		CategoryDelRs categoryDelRs = new CategoryDelRs();
		String response = null;
		Status status = new Status("999", "Status not set.");

		try {
			categoryDelRq = gson.fromJson(request, CategoryDelRq.class);
			validate(categoryDelRq);
			categoryDelRs.setResponseHeader(new ResponseHeader());
			categoryDelRs.getResponseHeader().setRquid(
					categoryDelRq.getRequestHeader().getRquid());
			del(categoryDelRq.getCategoryId());
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}

		categoryDelRs.setStatus(status);
		response = gson.toJson(categoryDelRs);
		System.out.println("response = " + response);
		return response;
	}

	/**
	 * Validate the category delete request message.
	 * 
	 * @param categoryDelRq
	 *            Category delete request message
	 * @throws StatusException
	 *             Throws a status exception if validation fails.
	 */
	private void validate(CategoryDelRq categoryDelRq) throws StatusException {
		if (categoryDelRq == null) {
			throw new StatusException("105", "CategoryDelRq must not be null.");
		}
		if (categoryDelRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"CategoryDelRq.requestHeader must not be null");
		}
		if (categoryDelRq.getCategoryId() == null
				|| categoryDelRq.getCategoryId().trim().length() == 0) {
			throw new StatusException("105",
					"CategoryDelRq.categoryId must be set");
		}
	}

	/**
	 * Delete the category from the database.
	 * 
	 * @param id
	 *            Category ID
	 * @throws StatusException
	 *             Throws status exception if there is an error.
	 */
	private void del(String id) throws StatusException {
		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();

			pStmt = conn.prepareStatement(CATEGORY_DELETE_BY_ID_SQL);
			pStmt.setString(1, id);
			pStmt.execute();

			pStmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new StatusException("800", e.toString());
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}

} // Class end
