package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.CalculateNetsal;

/**
 * Servlet implementation class SalaryServlet
 */
public class SalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalaryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Input:" + request.getParameter("basicSal"));

		double basicSal = new Double(request.getParameter("basicSal")
				.toString());

		CalculateNetsal calc = new CalculateNetsal();

		double netsal = calc.getNetSal(basicSal);

			
		System.out.println("Output:" + netsal);
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Your net salary: " + netsal + "</p>");
		// out.println("<p>"+ req.getParameter("name").toString()+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
