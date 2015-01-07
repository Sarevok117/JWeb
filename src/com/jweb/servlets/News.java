package com.jweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jweb.beans.NewsBean;
import com.jweb.forms.NewsForm;

public class News extends HttpServlet {
	public static final String COMMENT = "news";
    public static final String FORM = "form";
    public static final String SESSION = "session";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response);		
	}
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	NewsForm form = new NewsForm();
    	NewsBean news = form.newsUpdate(request);

        request.setAttribute(COMMENT, news);
        request.setAttribute(FORM, form);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response);
    }
}
