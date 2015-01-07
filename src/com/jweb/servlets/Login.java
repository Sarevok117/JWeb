package com.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jweb.beans.UserBean;
import com.jweb.forms.LoginForm;

public class Login extends HttpServlet {
    public static final String USER = "user";
    public static final String FORM = "form";
    public static final String SESSION = "session";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);		
	}
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LoginForm form = new LoginForm();
    	UserBean user = form.logInUser(request);
        HttpSession session = request.getSession();

        request.setAttribute(USER, user);
        request.setAttribute(FORM, form);
        
        if (form.getErrors().isEmpty()) {
            session.setAttribute(SESSION, user);
        } else {
            session.setAttribute(SESSION, null);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
