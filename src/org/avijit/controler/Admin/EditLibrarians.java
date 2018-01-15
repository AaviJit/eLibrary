package org.avijit.controler.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.LibrarianDAO;
import org.avijit.domain.LibrarianDetails;

/**
 * Servlet implementation class EditLibrarians
 */
@WebServlet("/EditLibrarians")
public class EditLibrarians extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditLibrarians() {
		super();

	}

	LibrarianDAO LibrarianDaoObject = new LibrarianDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strid = request.getParameter("id");
		int id = Integer.parseInt(strid);
		LibrarianDetails librarianObject = LibrarianDaoObject.getLibrarian(id);
		request.setAttribute("librarianObject", librarianObject);
		request.getRequestDispatcher("/WEB-INF/views/Admin/EditLibrarian.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strid = request.getParameter("id");
		int id = Integer.parseInt(strid);

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		LibrarianDetails editObject = new LibrarianDetails();

		editObject.setId(id);
		editObject.setName(name);
		editObject.setEmail(email);
		editObject.setPassword(password);
		editObject.setNumber(number);
		LibrarianDaoObject.updateLibrarian(editObject);
		response.sendRedirect("LibrarianInfo");
	}

}
