package com.jweb.forms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jweb.beans.CommentBean;
import com.jweb.beans.UserBean;

public class CommentForm {
	public static final String COMMENT_FIELD = "comment";
    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResult() {
    	return result;
    }
    
    public void setResult(String result) {
    	this.result = result;
    }
    
    public Map<String, String> getErrors() {
    	return errors;
    }
    
    public CommentBean commentProduct( HttpServletRequest request)
    {
    	String comment = request.getParameter(COMMENT_FIELD);
        CommentBean commentBean = new CommentBean();
        HttpSession session = request.getSession();
        UserBean user = (UserBean)session.getAttribute("session");
        if (session.getAttribute("session") == null) {
        	result = "You need to be logged to post comments.";
        	return commentBean;
        }
        
        try {
        	validateCom(comment);
        } catch (Exception e) {
            errors.put( COMMENT_FIELD, e.getMessage() );
        }
        commentBean.setComment(comment);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        commentBean.setDate(dateFormat.format(date));
        commentBean.setEmail(user.getEmail());
        commentBean.setName(user.getName());
        
        if (errors.isEmpty()) {
        	result = "Comment posted.";
        } else {
           	result = "Comment not posted.";            
        }
        
        return commentBean;
    }
    
    /**
     * Validates comment
     */
    private void validateCom( String comment ) throws Exception {
        if ( comment == null || comment.trim().length() == 0 )
        	throw new Exception( "Comment is empty" );
    }
}
