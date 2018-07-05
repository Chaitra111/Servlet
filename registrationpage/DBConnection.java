package com.bridgelabz.registrationpage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose : To get DB connection
 */
public class DBConnection {

	public static Connection createConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login?useSSL=false", "root", "root");
			} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
