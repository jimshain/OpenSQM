package com.opensqm.ws.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
import com.opensqm.json.CategoryInqRq;
import com.opensqm.json.CategoryInqRs;
import com.opensqm.json.ResponseHeader;
import com.opensqm.json.Status;

/**
 * Category inquiry message handler.
 * 
 * @author Jim Shain
 *
 */
@Controller
public class CategoryInq {

	private static final String CATEGORY_SELECT_ALL_SQL = "select CATEGORY_ID, CATEGORY_TEXT, WEIGHT from QUIZ_CATEGORY_TB";
	private static final String CATEGORY_SELECT_BY_ID_SQL = "select CATEGORY_ID, CATEGORY_TEXT, WEIGHT from QUIZ_CATEGORY_TB where CATEGORY_ID = ?";

	@RequestMapping(value = "categoryInq", method = RequestMethod.POST)
	public @ResponseBody String doCategoryInq(@RequestBody String request,
			ModelMap model) {
		Gson gson = new Gson();
		CategoryInqRq categoryInqRq = null;
		CategoryInqRs categoryInqRs = new CategoryInqRs();
		String response = null;
		Status status = new Status("999", "Status not set.");

		try {
			categoryInqRq = gson.fromJson(request, CategoryInqRq.class);
			validate(categoryInqRq);
			categoryInqRs.setResponseHeader(new ResponseHeader());
			categoryInqRs.getResponseHeader().setRquid(
					categoryInqRq.getRequestHeader().getRquid());
			categoryInqRs.setCategories(inq(categoryInqRq.getCategoryId()));
			status = new Status("0", "Success");
		} catch (StatusException se) {
			status = se.getStatus();
		} catch (Exception e) {
			status = new Status("999", e.toString());
			e.printStackTrace();
		}

		categoryInqRs.setStatus(status);
		response = gson.toJson(categoryInqRs);
		System.out.println("response = " + response);
		return response;
	}

	private void validate(CategoryInqRq categoryInqRq) throws StatusException {
		if (categoryInqRq == null) {
			throw new StatusException("105", "CategoryInqRq must not be null.");
		}
		if (categoryInqRq.getRequestHeader() == null) {
			throw new StatusException("105",
					"CategoryInqRq.requestHeader must not be null");
		}
	}

	private Category[] inq(String id) throws StatusException {
		List<Category> categoryList = new ArrayList<Category>();
		Category[] categories = null;
		Category category = null;

		InitialContext initialContext = null;
		Context context = null;
		DataSource ds = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try {
			initialContext = new InitialContext();
			context = (Context) initialContext.lookup("java:comp/env");
			ds = (DataSource) context.lookup("jdbc/OpenSQM");
			conn = ds.getConnection();

			if (id != null && id.trim().length() > 0) {
				pStmt = conn.prepareStatement(CATEGORY_SELECT_BY_ID_SQL);
				pStmt.setString(1, id);
			} else {
				pStmt = conn.prepareStatement(CATEGORY_SELECT_ALL_SQL);
			}
			rs = pStmt.executeQuery();

			while (rs.next()) {
				category = new Category();
				category.setId(rs.getString(1));
				category.setText(rs.getString(2));
				category.setWeight(rs.getInt(3));
				categoryList.add(category);
			}

			categories = new Category[categoryList.size()];
			categories = categoryList.toArray(categories);
			rs.close();
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

		return categories;
	}

} // Class end