package com.bridgelabz.registrationpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose :Validating all the entries of field in restration page, if it is correct then display home page 
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pwriter = response.getWriter();
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_pass = request.getParameter("confirmpassword");

		UserDetails registerBean = new UserDetails();
		registerBean.setFullName(fullname);
		registerBean.setEmail(email);
		registerBean.setUserName(username);
		registerBean.setPassword(password);

		RegisterDb registerDao = new RegisterDb();
		String userRegistered = registerDao.registerUser(registerBean);
		if (userRegistered.equals("SUCCESS") && password.equals(confirm_pass)) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession(true);
		    //String myName=(String)session.getAttribute("username");
		    //pwriter.print("Name: "+ myName);
			request.getRequestDispatcher("unsuccessful.jsp").forward(request, response);
		}
	}
}