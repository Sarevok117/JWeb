package com.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jweb.beans.UserBean;
import com.jweb.dao.UserDao;
import com.jweb.dao.DaoFactory;
import com.jweb.forms.SignUpForm;

public class SignUp extends HttpServlet {
    public static final String USER = "user";
    public static final String FORM = "form";
    
    private UserDao userDao;
    
    public void init() throws ServletException {
  		userDao = ((DaoFactory)getServletContext().getAttribute("daofactory")).getUserDao();
    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher( "/WEB-INF/signUp.jsp" ).forward( request, response );		
	}
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	SignUpForm form = new SignUpForm();
    	UserBean user = form.signUpUser(request);
    	if (form.getErrors().isEmpty()) {
    		userDao.create(user);
    	}
    	
        request.setAttribute(USER, user);
        request.setAttribute(FORM, form);
        
        this.getServletContext().getRequestDispatcher( "/WEB-INF/signUp.jsp" ).forward( request, response );
    }
}
