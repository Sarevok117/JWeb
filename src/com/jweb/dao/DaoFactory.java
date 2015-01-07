package com.jweb.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
	
	 private static final String PROPERTIES_FILE = "/com/jweb/dao/dao.properties";
	 private static final String PROP_URL = "url";
	 private static final String PROP_DRIVER = "driver";
	 private static final String PROP_USERNAME = "username";
	 private static final String PROP_PWD = "password";
	 
	 private String url;
	 private String username;
	 private String pwd;
	    
	 DaoFactory(String url, String username, String pwd) {
		 this.url = url;
	     this.username = username;
	     this.pwd = pwd;
    }
	    
    public static DaoFactory getInstance() throws DaoConfigurationException {
    	Properties properties = new Properties();
	    String url;
	    String driver;
	    String username;
	    String pwd;
	        
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    InputStream propFile = classLoader.getResourceAsStream(PROPERTIES_FILE);
	        
	    if (propFile == null) {
	    	throw new DaoConfigurationException("Properties file " + PROPERTIES_FILE + " not found");
	    }
	    try {
	        properties.load(propFile);
	        url = properties.getProperty(PROP_URL);
	        driver = properties.getProperty(PROP_DRIVER);
	        username = properties.getProperty(PROP_USERNAME);
	        pwd = properties.getProperty(PROP_PWD);
	    }
	    catch (IOException e) {
	    	throw new DaoConfigurationException("Could not load properties file " + PROPERTIES_FILE, e);
	    }
	        
	    try {
	        Class.forName(driver);
	    }
	    catch (ClassNotFoundException e) {
	        throw new DaoConfigurationException("Driver not found in classpath", e);
	    }
	        
	    DaoFactory instance = new DaoFactory(url, username, pwd);
	    return (instance);
    }
	    
	Connection getConnection() throws SQLException {
	    return DriverManager.getConnection(url, username, pwd);
	}
	    
	public UserDao getUserDao() {
	    return new UserDaoImpl(this);
	}
}
