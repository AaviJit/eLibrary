package org.avijit.controler.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.LibrarianDAO;
import org.avijit.domain.LibrarianDetails;

/**
 * Servlet implementation class LibrarianInfo
 */
@WebServlet("/LibrarianInfo")
public class LibrarianInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LibrarianDAO LibrarianDaoObject = new LibrarianDAO();

		List<LibrarianDetails> librarianList = LibrarianDaoObject.getAllLibrarian();
		request.setAttribute("librarianList", librarianList);
		request.getRequestDispatcher("/WEB-INF/views/Admin/ViewLibrarian.jsp").forward(request, response);
	}
}
