package org.avijit.controler.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.LibrarianDAO;

/**
 * Servlet implementation class DeleteLibrarian
 */
@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteLibrarian() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibrarianDAO LibrarianDaoObject = new LibrarianDAO();

		String strID = request.getParameter("id");
		int id = Integer.parseInt(strID);
		LibrarianDaoObject.deleteLibrarian(id);
		request.getRequestDispatcher("LibrarianInfo").forward(request, response);
	}
}
