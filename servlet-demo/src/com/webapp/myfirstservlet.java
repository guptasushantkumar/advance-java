package com.webapp;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyFirstServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
		//res.setStatus(200);
		res.setStatus(HttpServletResponse.SC_OK);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Today is Monday</p>");
		out.println("<p>"+ req.getParameter("name").toString()+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}