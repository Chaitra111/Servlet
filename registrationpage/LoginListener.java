package com.bridgelabz.registrationpage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Chaitra Ankolekar
 * Date : 18/05/2018 Purpose :Application Lifecycle
 * Listener implementation class LoginListener
 */
public class LoginListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("context destroyed");
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("context created");
	}
}
