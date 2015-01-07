package com.jweb.config;

import com.jweb.dao.DaoFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DaoFactoryInitializer implements ServletContextListener {
	private DaoFactory daoFactory;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		try {
			this.daoFactory = DaoFactory.getInstance();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("ICI CONNARD");
		if (this.daoFactory != null) {
			System.out.println("NUL");
		}
		servletContext.setAttribute("daofactory", this.daoFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}
}
