package com.bridgelabz.registrationpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :Servlet Filter for login page to restrict unfilled field 
 */
public class RegisterFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_pass = request.getParameter("confirmpassword");
		PrintWriter out = response.getWriter();

		if (fullname.equals("")) {
			out.println("<center>fullname cannot be empty</center>");
		} else if (email.equals("")) {
			out.println("<center>email cannot be empty</center>");
		} else if (username.equals("")) {
			out.println("<center>username cannot be empty</center>");
		} else if (password.equals("")) {
			out.println("<center>password cannot be empty</center>");
		} else if (confirm_pass.equals("")) {
			out.println("<center>confirm_password cannot be empty</center>");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
	}

}
