package com.bridgelabz.registrationpage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose : Get the field values from pojo class and inseret into database
 */
public class RegisterDb {
	
	public String registerUser(UserDetails register) {
		String fullname = register.getFullName();
		String email = register.getEmail();
		String username = register.getUserName();
		String password = register.getPassword();

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.createConnection();
			String query = "insert into user(sno,fullname,email,username,password) values (NULL,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, fullname);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, password);

			int i = preparedStatement.executeUpdate();

			if (i != 0) // Just to ensure data has been inserted into the database
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
	}
}