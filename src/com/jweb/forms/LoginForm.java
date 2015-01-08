package com.jweb.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jweb.beans.UserBean;
import com.jweb.dao.UserDao;

public class LoginForm {
	public static final String EMAIL_FIELD = "email";
    public static final String PWD_FIELD = "password";
    private String result;
    private Map<String, String> errors = new HashMap<String, String>();
    private UserDao userDao;
    
    public void setResult(String result) {
    	this.result = result;
    }
    
    public LoginForm(UserDao user) {
    	this.userDao = user;
    }
    
    public String getResult() {
    	return result;
    }
    
    public Map<String, String> getErrors() {
    	return errors;
    }
    
    public UserBean logInUser( HttpServletRequest request)
    {
    	String email = request.getParameter(EMAIL_FIELD);
        String password = request.getParameter(PWD_FIELD);
        UserBean user;
        
        try {
        	validateEmail(email);
        } catch (Exception e) {
            errors.put( EMAIL_FIELD, e.getMessage() );
        }
        user = userDao.find(email);
        if (user == null) {
        	errors.put( EMAIL_FIELD, "User not found");
        	return user;
        }
        
        try {
        	validatePassword(password);
        } catch (Exception e) {
            errors.put( PWD_FIELD, e.getMessage() );
    	}
        if (!user.getPassword().equals(password)) {
        	errors.put(PWD_FIELD, "Wrong password");
        }
        
        if (errors.isEmpty()) {
        	result = "User logged in.";
        } else {
        	result = "User not logged in";
        }
        
        return user;
    }
    
    /**
     * Validates email address
     */
    private void validateEmail( String email ) throws Exception {
        if ( email == null || email.trim().length() == 0  || !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) )
        	throw new Exception( "Invalid email adress." );
    }

    /**
     * Validates password
     */
    private void validatePassword( String password) throws Exception{
        if (password != null && password.trim().length() != 0) {
            if (password.trim().length() < 3) {
                throw new Exception("Passwords must contain at least 3 characters");
            }
        } else {
            throw new Exception("Password and confirmation are missing.");
        }
    }

}
