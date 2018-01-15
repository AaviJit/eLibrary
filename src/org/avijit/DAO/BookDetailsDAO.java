package org.avijit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.avijit.domain.BookInfo;
import org.avijit.domain.IssuedBookClass;

import com.mysql.jdbc.Statement;

public class BookDetailsDAO {

	static Connection conn;
	static PreparedStatement ps;
	static ResultSet rs;
	static Statement st;

	public void AddBook(BookInfo obj) {
		try {
			conn = DBConnection.getConnection();
			ps = conn
					.prepareStatement("insert into BookList (CallNo,Name,Author,Publisher,Quantity) values(?,?,?,?,?)");
			ps.setString(1, obj.getCallNo());
			ps.setString(2, obj.getName());
			ps.setString(3, obj.getAuthor());
			ps.setString(4, obj.getPublisher());
			ps.setInt(5, obj.getQuantity());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void IssueBook(String studentId, String callNo, String name, String number) {
		try {

			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(
					"insert into IssueBookTable (studentID,callNo,studentName,studentNumber,date) values(?,?,?,?,?)");
			ps.setString(1, studentId);
			ps.setString(2, callNo);
			ps.setString(3, name);
			ps.setString(4, number);
			java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
			String date = currentDate.toString();
			ps.setString(5, date);
			int status = ps.executeUpdate();
			if (status > 0) {
				st = (Statement) conn.createStatement();
				rs = st.executeQuery("select * from BookList");
				if (rs.next()) {
					PreparedStatement ps2 = conn
							.prepareStatement("update BookList set Quantity=?,Issued = ? where CallNo = ?");
					ps2.setInt(1, (rs.getInt(5)) - 1);
					ps2.setInt(2, (rs.getInt(6)) + 1);
					ps2.setString(3, callNo);
					ps2.executeUpdate();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void ReturnBook(String callNo, String studentID) {
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("update IssueBookTable set ReturnStatus = 'Yes' where studentID =? ");
			ps.setString(1, studentID);
			ps.executeUpdate();

			st = (Statement) conn.createStatement();
			rs = st.executeQuery("select * from BookList");
			if (rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("update BookList set Quantity=?,Issued=? where CallNo=?");
				ps2.setInt(1, rs.getInt(5) + 1);
				ps2.setInt(2, rs.getInt(6) - 1);
				ps2.setString(3, callNo);
				ps2.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public List<BookInfo> getAllBook() {
		List<BookInfo> BookList = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			st = (Statement) conn.createStatement();
			rs = st.executeQuery("select * from BookList");
			while (rs.next()) {
				BookInfo bookObject = new BookInfo();

				bookObject.setCallNo(rs.getString(1));
				bookObject.setName(rs.getString(2));
				bookObject.setAuthor(rs.getString(3));
				bookObject.setPublisher(rs.getString(4));
				bookObject.setQuantity(rs.getInt(5));
				bookObject.setIssued(rs.getInt(6));

				BookList.add(bookObject);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return BookList;
	}

	public List<IssuedBookClass> ViewIssuedBook() {
		List<IssuedBookClass> issuedBookList = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			st = (Statement) conn.createStatement();
			rs = st.executeQuery("select * from IssueBookTable");
			while (rs.next()) {
				IssuedBookClass issuedBookObject = new IssuedBookClass();
				issuedBookObject.setStudentId(rs.getString(1));
				issuedBookObject.setCallNo(rs.getString(2));
				issuedBookObject.setStudentName(rs.getString(3));
				issuedBookObject.setPhoneNumber(rs.getString(4));
				issuedBookObject.setDate(rs.getString(5));
				issuedBookObject.setReturnStatus(rs.getString(6));
				issuedBookList.add(issuedBookObject);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return issuedBookList;

	}

}
