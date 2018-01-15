package org.avijit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			System.out.println("connection Established");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
