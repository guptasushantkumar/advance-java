package com.webapp;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthServlet
 */
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Set<String> sUName;

	private static Set<String> sUPass;

	private static int userCount;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String userName = this.getServletConfig().getInitParameter("username");
		String userPass = this.getServletConfig().getInitParameter("password");

		String[] arrUName = userName.split(",");
		String[] arrUPass = userPass.split(",");

		sUName = new HashSet<String>(Arrays.asList(arrUName));
		sUPass = new HashSet<String>(Arrays.asList(arrUPass));

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User reqUser = new User(request.getParameter("userName"),
				request.getParameter("userPass"));

		User sessUser = (User) request.getSession().getAttribute("user");

		/*System.out.println("EqualsCheck:" + reqUser.equals(sessUser));

		System.out.println("hashCheck:"
				+ (reqUser.hashCode() == sessUser.hashCode()));*/

		if (null != sessUser && (reqUser.equals(sessUser) == true)
				&& ((reqUser.hashCode() == sessUser.hashCode()) == true)) {

			request.setAttribute("message", "You have already logged in");
			getServletContext().getRequestDispatcher("/login.jsp").forward(
					request, response);
		} else {

			ValidateUser val = new ValidateUser(request);
			boolean check = val.isValid(sUName, sUPass);

			if (check == true) {

				request.getSession().setAttribute("user", reqUser);
				request.setAttribute("message",
						"You have logged in successfully!");
				userCount = userCount + 1;
				this.getServletContext().setAttribute("userCount", userCount);
				getServletContext().getRequestDispatcher("/home.jsp").forward(
						request, response);
			} else {
				request.setAttribute("message",
						"Incorrect username or password");
				getServletContext().getRequestDispatcher("/login.jsp").forward(
						request, response);
			}
		}
	}

}
