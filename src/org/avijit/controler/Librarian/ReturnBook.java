package org.avijit.controler.Librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.BookDetailsDAO;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReturnBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/User/ReturnBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookDetailsDAO BookDetailsDaoObject = new BookDetailsDAO();

		String CallNo = request.getParameter("callNo");
		String StudentID = request.getParameter("studentID");
		BookDetailsDaoObject.ReturnBook(CallNo, StudentID);
		response.sendRedirect("LibrarianPage");

	}

}
