package com.jweb.dao;

import com.jweb.beans.UserBean;

public interface UserDao {
	void create(UserBean user) throws DaoException;
	UserBean find(String email) throws DaoException;
}
