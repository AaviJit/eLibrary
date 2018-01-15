package org.avijit.utils;

import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static boolean validAdminLogin(HttpServletRequest request) {
		return request.getSession().getAttribute("AdminAuth") != null
				&& request.getSession().getAttribute("AdminAuth").equals("True");
	}

	public static boolean validLibrarianLogin(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return loggedInAsLibrarian(request) && permittedUrls(requestURI);
	}

	public static boolean loggedInAsLibrarian(HttpServletRequest request) {
		return request.getSession().getAttribute("LibrarianAuth") != null
				&& request.getSession().getAttribute("LibrarianAuth").equals("Ok");
	}

	public static boolean permittedUrls(String uri) {
		return !(uri.equals("/TestProject/HomePage") || uri.equals("/TestProject/AddLibrarian")
				|| uri.equals("/TestProject/LibrarianInfo"));
	}

}
