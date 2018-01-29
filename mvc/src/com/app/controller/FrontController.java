package com.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.action.Action;
import com.app.action.InsertItemAction;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Action action = null;
		if (req.getRequestURI().contains("insert-item")) {
			action = new InsertItemAction();
			String result = action.execute(req, resp);
			if(result.equalsIgnoreCase("success")){
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}else{
				req.getRequestDispatcher("insert-item.jsp").forward(req, resp);
			}
		}
	}
}
