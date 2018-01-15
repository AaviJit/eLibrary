package org.avijit.controler.auth;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.utils.Utils;

@WebFilter("/*")
public class AuthencationFilter implements Filter {

	public AuthencationFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestURI = httpRequest.getRequestURI();
		if ("/TestProject/CheckAdminLogin".equals(requestURI)
				|| "/TestProject/CheckLibrarianLogin".equals(requestURI)) {
			chain.doFilter(request, response);
		} else {
			if (Utils.validAdminLogin(httpRequest) || Utils.validLibrarianLogin(httpRequest)) {
				chain.doFilter(request, response);
			} else if (Utils.loggedInAsLibrarian(httpRequest) && !Utils.permittedUrls(requestURI)) {
				httpResponse.sendRedirect("ErrorPage");
			} else {
				request.getRequestDispatcher("CheckLibrarianLogin").forward(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
