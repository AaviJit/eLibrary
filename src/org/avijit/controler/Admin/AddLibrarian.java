package org.avijit.controler.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.LibrarianDAO;
import org.avijit.domain.LibrarianDetails;

@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/Admin/AddLibrarian.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibrarianDetails obj = new LibrarianDetails();

		LibrarianDAO LibrarianDaoObject = new LibrarianDAO();

		if (request.getParameter("name").isEmpty() == false && request.getParameter("email").isEmpty() == false
				&& request.getParameter("password").isEmpty() == false
				&& request.getParameter("number").isEmpty() == false) {

			obj.setName(request.getParameter("name"));
			obj.setEmail(request.getParameter("email"));
			obj.setPassword(request.getParameter("password"));
			obj.setNumber(request.getParameter("number"));
			LibrarianDaoObject.addLibrarian(obj);

			request.setAttribute("successMessage", "Registration Complete");
			request.getRequestDispatcher("HomePage").forward(request, response);

		} else {
			request.setAttribute("emptyMessage", "Any Field cannot be empty! Fill carefully !");
			request.getRequestDispatcher("/WEB-INF/views/Admin/AddLibrarian.jsp").forward(request, response);
		}
	}

}
