package org.avijit.controler.Librarian;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.BookDetailsDAO;
import org.avijit.domain.IssuedBookClass;

/**
 * Servlet implementation class ViewIssuedBook
 */
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDetailsDAO BookDetailsDaoObject = new BookDetailsDAO();

		List<IssuedBookClass> IssuedList = BookDetailsDaoObject.ViewIssuedBook();
		request.setAttribute("IssuedList", IssuedList);
		request.getRequestDispatcher("/WEB-INF/views/User/ViewIssuedBook.jsp").forward(request, response);

	}

}
