package com.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jweb.beans.CommentBean;
import com.jweb.forms.CommentForm;

public class Comment extends HttpServlet {
	public static final String COMMENT = "comment";
    public static final String FORM = "form";
    public static final String SESSION = "session";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);		
	}
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	CommentForm form = new CommentForm();
    	CommentBean comment = form.commentProduct(request);

        request.setAttribute(COMMENT, comment);
        request.setAttribute(FORM, form);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);
    }
}
