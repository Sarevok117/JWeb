package com.jweb.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jweb.beans.UserBean;

public class LoginForm {
	public static final String EMAIL_FIELD = "email";
    public static final String PWD_FIELD = "password";
    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

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
        UserBean user = new UserBean();
        
        try {
        	validateEmail(email);
        } catch (Exception e) {
            errors.put( EMAIL_FIELD, e.getMessage() );
        }
        user.setEmail(email);
        
        try {
        	validatePassword(password);
        } catch (Exception e) {
            errors.put( PWD_FIELD, e.getMessage() );
    	}
        user.setPassword(password);
        
        if (errors.isEmpty()) {
        	result = "User logged in.";
        } else {
        	result = "User not logged in";
        }
        
        return user;
    }
    
    // TODO: VALIDATION FUNCS
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
