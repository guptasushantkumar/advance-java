package com.app.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestTableTag
 */
public class TestTableTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<String> tableHeaders;

	private List<MovieSchedule> tableValues;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestTableTag() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		tableHeaders = new ArrayList<>();
		tableHeaders.add("Movie Name");
		tableHeaders.add("Show Time");

		tableValues = new ArrayList<>();
		tableValues.add(new MovieSchedule("Children of Heaven",
				"9:00, 11:30, 15:00, 17:30"));
		tableValues.add(new MovieSchedule("Erin Brokovich",
				"10:00, 12:30, 14:30, 16:30"));
		tableValues.add(new MovieSchedule("Naayagan",
				"9:30, 13:00, 17:00, 20:30"));
		tableValues
				.add(new MovieSchedule("Babel", "9:00, 11:30, 15:00, 17:30"));
		tableValues.add(new MovieSchedule("Jaane Bhi Do Yaaron",
				"9:30, 13:00, 17:00, 20:30"));
		
		request.setAttribute("header", tableHeaders);
		request.setAttribute("values", tableValues);
		
		this.getServletContext().getRequestDispatcher("/table.jsp").forward(
				request, response);
	}

}
