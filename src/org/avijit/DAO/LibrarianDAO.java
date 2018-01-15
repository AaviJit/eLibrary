package org.avijit.DAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import org.avijit.domain.LibrarianDetails;

import com.mysql.jdbc.Statement;

public class LibrarianDAO {
	static Connection conn;
	static PreparedStatement ps;
	static ResultSet rs;
	static Statement st;

	public boolean AdminAuthenticattion(String email, String password) throws SQLException {
		boolean status = false;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from AdminTable where email =? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public boolean LibrarianAuthenticattion(String email, String password) throws SQLException {
		boolean status = false;
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from Librarian where Email =? and Password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public void addLibrarian(LibrarianDetails obj) {
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("insert into Librarian (FirstName,Email,Password,Number) values (?,?,?,?)");
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getPassword());
			ps.setString(4, obj.getNumber());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteLibrarian(int id) {
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("delete from Librarian where ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateLibrarian(LibrarianDetails obj) {
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("update Librarian set FirstName=?,Email=?,Password=?,Number=? where ID=?;");
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getPassword());
			ps.setString(4, obj.getNumber());
			ps.setInt(5, obj.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public LibrarianDetails getLibrarian(int id) {
		LibrarianDetails obj = new LibrarianDetails();

		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement("select * from Librarian where ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setEmail(rs.getString(3));
				obj.setPassword(rs.getString(4));
				obj.setNumber(rs.getString(5));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return obj;
	}

	public List<LibrarianDetails> getAllLibrarian() {
		List<LibrarianDetails> resultList = new ArrayList<>();
		try {
			conn = DBConnection.getConnection();
			st = (Statement) conn.createStatement();
			rs = st.executeQuery("select * from Librarian");
			while (rs.next()) {
				LibrarianDetails librarian = new LibrarianDetails();
				librarian.setId(rs.getInt(1));
				librarian.setName(rs.getString(2));
				librarian.setEmail(rs.getString(3));
				librarian.setPassword(rs.getString(4));
				librarian.setNumber(rs.getString(5));

				resultList.add(librarian);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return resultList;
	}

}
