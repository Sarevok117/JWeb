package com.jweb.dao;

import com.jweb.beans.CommentBean;

public interface CommentDao {
	void create(CommentBean comment) throws DaoException;
	CommentBean find(String email) throws DaoException;
}
