package org.avijit.controler.Admin;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.avijit.DAO.LibrarianDAO;

@WebServlet("/CheckAdminLogin")
public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In admin login get");
		request.getRequestDispatcher("/WEB-INF/views/Auth/adminLogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibrarianDAO LibrarianDaoObject = new LibrarianDAO();

		String email = request.getParameter("admin_email");
		String password = request.getParameter("admin_password");
		try {
			boolean result = LibrarianDaoObject.AdminAuthenticattion(email, password);
			if (result != false) {
				request.getSession().setAttribute("AdminAuth", "True");
				response.sendRedirect("HomePage");
			} else {
				request.setAttribute("ErrorMessage", "Error Email or Password !!");
				request.getRequestDispatcher("/WEB-INF/views/Auth/adminLogin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
