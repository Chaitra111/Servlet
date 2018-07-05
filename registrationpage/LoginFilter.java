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
public class LoginFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if (un.equals("")) {
			out.println("<center>username cannot be empty</center>");
			/*out.println("<script type=\"text/javascript\">");
			out.println("alert('Password cannot be empty');");
			out.println("</script>");
		 	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			 */
			//rd.forward(request, response);
		} else if (pw.equals("")) {
			out.println("<center>password cannot be empty</center>");
			/*out.println("<script type=\"text/javascript\">");
			out.println("alert('Password cannot be empty');");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);*/
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}
}
