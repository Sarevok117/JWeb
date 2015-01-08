package com.jweb.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jweb.beans.NewsBean;
import com.jweb.dao.DaoException;
import com.jweb.dao.DaoFactory;
import com.jweb.dao.NewsDao;
import com.jweb.forms.NewsForm;

public class News extends HttpServlet {
	public static final String COMMENT = "news";
    public static final String FORM = "form";
    public static final String SESSION = "session";
    public static final String NEWS = "list";
    private NewsDao newsDao;

    public void init() throws ServletException {
  		newsDao = ((DaoFactory)getServletContext().getAttribute("daofactory")).getNewsDao();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	Collection<NewsBean> news;
    	
    	try {
		news = newsDao.findAll();
		request.setAttribute(NEWS, news);
    	}
    	catch (DaoException e) {
    		System.out.println(e.getMessage());
    	}
		this.getServletContext().getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response);		
	}
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	NewsForm form = new NewsForm();
    	NewsBean news = form.newsUpdate(request);
    	Collection<NewsBean> allNews;

    	if (form.getErrors().isEmpty()) {
    		try {
    			newsDao.create(news);
    			
    		}
    		catch (DaoException e) {
    			form.setResult(e.getMessage());
    		}
    	}
    	try {
    		allNews = newsDao.findAll();
    		request.setAttribute(NEWS, allNews);
    	}
    	catch (DaoException e) {
    		form.setResult(e.getMessage());
    	}
    	request.setAttribute(COMMENT, news);
        request.setAttribute(FORM, form);
       
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/news.jsp").forward(request, response);
    }
}
