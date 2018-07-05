package com.bridgelabz.registrationpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose : Validating username and password
 */
public class LoginDb {

	static Connection con = null;
	static PreparedStatement preparedStatement = null;

	public static boolean validation(String username, String password) {
		boolean result = false;
		try {
			con = DBConnection.createConnection();
			String query = "select * from user where username=? and password=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			result = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String validationPassword(String email) {
		String password = "";
		try {
			con = DBConnection.createConnection();
			String query = "select password from user where email='" + email + "'";
			preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				password = rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
}
