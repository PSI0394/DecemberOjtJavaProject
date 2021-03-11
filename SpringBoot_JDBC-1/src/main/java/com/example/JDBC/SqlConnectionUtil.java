package com.example.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnectionUtil {

	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dec_ojt", "root", "root");
			System.out.println("Connected....");
		} catch (Exception e) {

			e.printStackTrace();
		}

		return con;

	}

}
