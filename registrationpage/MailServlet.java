package com.bridgelabz.registrationpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String to = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
   //     SendMail.send(to,subject, message, username, password);
        out.println("Mail send successfully");
    }   
}
