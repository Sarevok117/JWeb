package com.jweb.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jweb.beans.NewsBean;
import com.jweb.beans.UserBean;

public class NewsForm {
	public static final String COMMENT_FIELD = "news";
    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResult() {
    	return result;
    }
    
    public Map<String, String> getErrors() {
    	return errors;
    }
    
    public NewsBean newsUpdate( HttpServletRequest request)
    {
    	String news = request.getParameter(COMMENT_FIELD);
        NewsBean newsBean = new NewsBean();
        HttpSession session = request.getSession();
        UserBean user = (UserBean)session.getAttribute("session");
        if (user == null) {
        	result = "You need to be logged to post news.";
        	return newsBean;
        } else if (user.getAdmin() == false){
        	result = "You need to be admin to post news.";
        	return newsBean;        	
        }
        try {
        	validateCom(news);
        } catch (Exception e) {
            errors.put( COMMENT_FIELD, e.getMessage() );
        }
        newsBean.setNews(news);
        
        if (session.getAttribute("session") != null && errors.isEmpty()) {
        	result = "News posted.";
        } else {
           	result = "News not posted.";            
        }
        
        return newsBean;
    }
    
    // TODO: VALIDATION FUNCS
    /**
     * Validates news
     */
    private void validateCom( String news ) throws Exception {
        if ( news == null || news.trim().length() == 0 )
        	throw new Exception( "News is empty" );
    }
}
