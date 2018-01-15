package org.avijit.controler.Librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.BookDetailsDAO;

@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IssueBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/User/IssueBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookDetailsDAO BookDetailsDaoObject = new BookDetailsDAO();

		String studentId = request.getParameter("studentID");
		String callNo = request.getParameter("callNo");
		String name = request.getParameter("studentName");
		String number = request.getParameter("studentMobile");
		BookDetailsDaoObject.IssueBook(studentId, callNo, name, number);
		request.getRequestDispatcher("/WEB-INF/views/User/IssueBook.jsp").forward(request, response);

	}

}
