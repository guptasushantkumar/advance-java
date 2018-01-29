package com.webapp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListAllFilesServlet
 */
public class ListAllFilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String dirPath = ctx.getInitParameter("folderpath");
		System.out.println("folderpath" + ctx.getInitParameter("folderpath"));

		URL dirURL = this.getClass().getResource(dirPath);
		System.out.println("dir:" + dirURL);
		File dir;
		try {
			dir = new File(dirURL.toURI());

			File[] listOfFiles = dir.listFiles();
			System.out.println("Dir yes" + dir.isDirectory());

			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");

			for (File fl : listOfFiles) {
				System.out.println("File name" + fl.getName());
				out.println("<a href=\"download?file=" + fl.getName() + "\">"
						+ fl.getName() + "</a>");
				out.println("<br/>");
			}

			// out.println("<p>"+ req.getParameter("name").toString()+"</p>");
			out.println("</body>");
			out.println("</html>");

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
