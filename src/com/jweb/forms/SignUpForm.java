package com.jweb.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jweb.beans.UserBean;

public class SignUpForm {
    public static final String EMAIL_FIELD = "email";
    public static final String PWD_FIELD = "password";
    public static final String CONF_FIELD = "confirmation";
    public static final String NAME_FIELD = "name";
    private String result;
    private Map<String, String> errors = new HashMap<String, String>();
    
    public String getResult() {
    	return result;
    }
    
    public Map<String, String> getErrors() {
    	return errors;
    }
    
    public UserBean signUpUser( HttpServletRequest request)
    {
    	String email = request.getParameter(EMAIL_FIELD);
        String password = request.getParameter(PWD_FIELD);
        String confirmation = request.getParameter(CONF_FIELD);
        String name = request.getParameter(NAME_FIELD);
        UserBean user = new UserBean();
        
        user.setAdmin(false);
        try {
        	validateEmail(email);
        } catch (Exception e) {
            errors.put( EMAIL_FIELD, e.getMessage() );
        }
        user.setEmail(email);
        
        try {
        	validatePassword(password, confirmation);
        } catch (Exception e) {
            errors.put( PWD_FIELD, e.getMessage() );
    	}
        user.setPassword(password);
        
        try {
        	validateName(name);
        } catch (Exception e) {
            errors.put( NAME_FIELD, e.getMessage() );	
        }
        user.setName(name);
        
        if (errors.isEmpty()) {
        	result = "User signed up.";
        } else {
        	result = "User not signed up";
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
    private void validatePassword( String password, String confirmation ) throws Exception{
        if (password != null && password.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
            if (!password.equals(confirmation)) {
                throw new Exception("Password and confirmation don't match.");
            } else if (password.trim().length() < 3) {
                throw new Exception("Passwords must contain at least 3 characters");
            }
        } else {
            throw new Exception("Password and confirmation are missing.");
        }
    }

    /**
     * Validates name
     */
    private void validateName( String name ) throws Exception {
        if ( name != null && name.trim().length() < 3 ) {
            throw new Exception( "User name must contain at least 3 characters." );
        }
    }
}
