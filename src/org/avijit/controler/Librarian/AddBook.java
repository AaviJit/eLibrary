package org.avijit.controler.Librarian;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.avijit.DAO.BookDetailsDAO;
import org.avijit.domain.BookInfo;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBook() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/User/AddBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookDetailsDAO BookDetailsDaoObject = new BookDetailsDAO();

		BookInfo bookObj = new BookInfo();

		if (request.getParameter("collNo").isEmpty() == false && request.getParameter("name").isEmpty() == false
				&& request.getParameter("author").isEmpty() == false
				&& request.getParameter("publisher").isEmpty() == false
				&& request.getParameter("quantity").isEmpty() == false) {
			bookObj.setCallNo(request.getParameter("collNo"));
			bookObj.setName(request.getParameter("name"));
			bookObj.setAuthor(request.getParameter("author"));
			bookObj.setPublisher(request.getParameter("publisher"));
			String quantityStr = request.getParameter("quantity");
			int quantity = Integer.parseInt(quantityStr);
			bookObj.setQuantity(quantity);

			BookDetailsDaoObject.AddBook(bookObj);

			request.setAttribute("BookEdition", "Saved Book Successfully");
			request.getRequestDispatcher("/WEB-INF/views/User/AddBook.jsp").forward(request, response);

		}

		else {
			request.setAttribute("BookEditionError", "Field cannot be empty !!");
			request.getRequestDispatcher("/WEB-INF/views/User/AddBook.jsp").forward(request, response);

		}

	}

}
