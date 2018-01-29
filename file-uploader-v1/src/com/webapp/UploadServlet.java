package com.webapp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "sakinaka";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 50; // 50 kb
	private static final int MAX_REQUEST_SIZE = 1024 * 1000; // 1MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Enumeration<String> headerNames = request.getHeaderNames(); while
		 * (headerNames.hasMoreElements()) { String headerName =
		 * headerNames.nextElement(); System.out.println("Header Name: <em>" +
		 * headerName); String headerValue = request.getHeader(headerName);
		 * System.out.println("</em>, Header Value: <em>" + headerValue);
		 * System.out.println("</em><br/>"); }
		 * 
		 * System.out.println(request.getParameter("fileName"));
		 * System.out.println(request.getParameter("mimeType"));
		 * System.out.println(request.getParameter("fileSize"));
		 * 
		 * if (m.getParameter("fileSize") != null) { int fileSize = new
		 * Integer(request.getParameter("fileSize") .toString());
		 * //System.out.println("fileSize" + fileSize / 1024 + "kb"); if
		 * (fileSize < 50 || fileSize > (50 * 1024)) {
		 * System.out.println("Error"); response.sendError(500);
		 * 
		 * } else { ServletInputStream sis = request.getInputStream(); byte[]
		 * buf = new byte[request.getContentLength()]; sis.read(buf, 0,
		 * buf.length); File file = new
		 * File("C:\\"+request.getParameter("fileName")); FileOutputStream fos =
		 * new FileOutputStream(file); fos.write(buf); sis.close(); fos.flush();
		 * fos.close(); } //}
		 */
		// configures upload settings
		// checks if the request actually contains upload file
		if (!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter writer = response.getWriter();
			writer.println("Request does not contain upload data");
			writer.flush();
			return;
		}

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		String uploadPath = getServletContext().getRealPath("")
				+ File.separator + UPLOAD_DIRECTORY;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			List formItems = upload.parseRequest(request);
			Iterator iter = formItems.iterator();

			// iterates over form's fields
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// processes only fields that are not form fields
				if (!item.isFormField()) {
					String fileName = new File(item.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);

					// saves the file on disk
					item.write(storeFile);
				}
			}
			request.setAttribute("message",
					"Upload has been done successfully!");
			getServletContext().getRequestDispatcher("/message.jsp").forward(
					request, response);
		} catch (Exception ex) {
			request.setAttribute("message",
					"There was an error: " + ex.getMessage());
			response.sendError(500);
		}

	}
}
