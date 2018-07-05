package com.bridgelabz.registrationpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018
 * Purpose : Validating username and password if it is correct then display welcome page
 */
public class LoginController extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		if(LoginDb.validation(un,pw))
		{	
			RequestDispatcher rd= request.getRequestDispatcher("welcome_2.jsp");
			rd.forward(request, response);			
		}
		else
		{
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Sorry, Password and Username Error');");  
	    		out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
