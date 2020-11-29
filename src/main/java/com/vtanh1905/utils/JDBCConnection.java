package com.vtanh1905.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		final String DB_URL = "jdbc:mysql://localhost:3306/crm";
		final String USER_NAME = "root";
		final String PASSWORD = "123456";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
