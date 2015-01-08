package com.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jweb.beans.UserBean;
import com.jweb.dao.DaoException;
import com.jweb.dao.DaoFactory;
import com.jweb.dao.UserDao;
import com.jweb.forms.LoginForm;

public class Login extends HttpServlet {
    public static final String USER = "user";
    public static final String FORM = "form";
    public static final String SESSION = "session";
    private UserDao userDao;
    
    public void init() throws ServletException {
  		userDao = ((DaoFactory)getServletContext().getAttribute("daofactory")).getUserDao();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);		
	}
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LoginForm form = new LoginForm(userDao);
    	HttpSession session = request.getSession();
    	
    	try {
    		UserBean user = form.logInUser(request);
    		

    		request.setAttribute(USER, user);
    		request.setAttribute(FORM, form);

    		if (form.getErrors().isEmpty()) {
    			session.setAttribute(SESSION, user);
    			this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    		} else {
    			session.setAttribute(SESSION, null);
    			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    		}
    	}
    	catch (DaoException e) {
    		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    		System.out.println(e.getMessage());
    	}
    }
}
