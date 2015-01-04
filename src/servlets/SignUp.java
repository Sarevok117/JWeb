package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import forms.SignUpForm;

public class SignUp extends HttpServlet {
    public static final String USER = "user";
    public static final String FORM = "form";
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher( "/WEB-INF/signUp.jsp" ).forward( request, response );		
	}
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	SignUpForm form = new SignUpForm();
    	UserBean user = form.signUpUser(request);
    	        
        request.setAttribute(USER, user);
        request.setAttribute(FORM, form);
        
        this.getServletContext().getRequestDispatcher( "/WEB-INF/signUp.jsp" ).forward( request, response );
    }
}
