package com.bridgelabz.registrationpage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :Servlet class to forward the request to register page
 */
public class RegisterClass extends HttpServlet {
	 
		private static final long serialVersionUID = 1L;
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.getRequestDispatcher("register.jsp").forward(request, response);

}
}