package org.avijit.controler.Librarian;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.LibrarianDAO;

/**
 * Servlet implementation class CheckLibrarianLogin
 */
@WebServlet("/CheckLibrarianLogin")
public class CheckLibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckLibrarianLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Auth/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibrarianDAO LibrarianDaoObject = new LibrarianDAO();

		String email = request.getParameter("librarian_email");
		String password = request.getParameter("librarian_password");

		try {
			Boolean result = LibrarianDaoObject.LibrarianAuthenticattion(email, password);
			if (result) {
				request.getSession().setAttribute("LibrarianAuth", "Ok");
				response.sendRedirect("LibrarianPage");
			} else {
				request.setAttribute("LibrarianErrorMessage", "Error Email or Password !!");
				request.getRequestDispatcher("/WEB-INF/views/Auth/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
