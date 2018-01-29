package com.webapp;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class ValidateUser {

	private HttpServletRequest request;

	public ValidateUser(HttpServletRequest request) {
		this.request = request;
	}

	public boolean isValid(Set<String> sUName, Set<String> sUPass) {
		String reqUserName = request.getParameter("userName");
		String reqUserPass = request.getParameter("userPass");

		boolean nameMatch = sUName.contains(reqUserName);
		boolean passMatch = sUPass.contains(reqUserPass);

		if (nameMatch == true && passMatch == true) {
			return true;
		} else {
			return false;
		}
	}

}
