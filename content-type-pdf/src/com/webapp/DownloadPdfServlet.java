package com.webapp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadPdfServlet
 */
public class DownloadPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("reached");
		String filename = request.getParameter("file");
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename="
				+ filename);
		ServletOutputStream out = response.getOutputStream();
		URL dirURL = this.getClass().getResource(
				"/com/resources/documents/" + filename);
		File file = null;
		try {
			file = new File(dirURL.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fsIn = new FileInputStream(file);
		BufferedInputStream buf = null;
		buf = new BufferedInputStream(fsIn);
		int readBytes = 0;

		// read from the file; write to the ServletOutputStream
		while ((readBytes = buf.read()) != -1) {
			out.write(readBytes);
		}
		out.flush();
		out.close();
	}
}
