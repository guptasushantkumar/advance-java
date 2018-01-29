package com.webapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
public class CounterServlet extends HttpServlet {
	private static long servletDeployedAt = 0;
	private static final long serialVersionUID = 1L;
	private static int recvdReqCount = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CounterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		servletDeployedAt = System.currentTimeMillis();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		recvdReqCount = recvdReqCount + 1;

		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Your requests count: " + recvdReqCount + "</p>");
		// out.println("<p>"+ req.getParameter("name").toString()+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		recvdReqCount = recvdReqCount + 1;

		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Your requests count: " + recvdReqCount + "</p>");
		// out.println("<p>"+ req.getParameter("name").toString()+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();

		try {
			FileWriter write = new FileWriter(new File("C:\\counter.txt"));
			write.append("Servlet deployed for: "
					+ ((System.currentTimeMillis() - servletDeployedAt) / 1000)
					+ "seconds");
			write.append("\n");
			write.append("Your requests count: " + recvdReqCount);
			write.flush();
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}

	}

}
