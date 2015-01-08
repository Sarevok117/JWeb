package com.jweb.dao;

import java.util.Collection;

import com.jweb.beans.NewsBean;

public interface NewsDao {
	void create(NewsBean news) throws DaoException;
	NewsBean find(int id) throws DaoException;
	public Collection<NewsBean> findAll() throws DaoException;
}
