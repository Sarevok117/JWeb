package com.jweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.jweb.beans.CommentBean;
import com.jweb.beans.NewsBean;

public class NewsDaoImpl implements NewsDao {
	private DaoFactory daoFactory;
	private static final String SQL_INSERT = "INSERT INTO news (content, date, userEmail) VALUES (?, ?, ?)";
	
	NewsDaoImpl(DaoFactory factory) {
		this.daoFactory = factory;
	}
	
	@Override
	public void create(NewsBean news) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection();
			java.util.Date utilDate = new java.util.Date();
			statement = DaoUtils.initStatement(connection, SQL_INSERT, true, news.getContent(), new java.sql.Date(utilDate.getTime()), news.getUserEmail());
			int status = statement.executeUpdate();
			if (status == 0) {
				throw new DaoException("Failed to add a new news, no line added in table");
			}
			resultSet = statement.getGeneratedKeys();
			if (!resultSet.next()) {
				throw new DaoException("Failed to add a new news, no ID generated");
			}

		}
		catch (SQLException e) {
			throw new DaoException("Failed to add a new news");
		}
		finally {
			DaoUtils.closeParams(statement, connection, resultSet);
		}
		
	}
	
	public Collection<NewsBean> findAll() throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Collection<NewsBean> news = new ArrayList<NewsBean>();

		try {
			connection = daoFactory.getConnection();
			statement = DaoUtils.initStatement(connection, "SELECT * FROM news", false);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				news.add(map(resultSet));
			}
		}
		catch (SQLException e) {
			throw new DaoException(e);
		}
		finally {
			DaoUtils.closeParams(statement, connection, resultSet);
		}
		return news;
	}
		

	@Override
	public NewsBean find(int id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		NewsBean news = null;

		try {
			connection = daoFactory.getConnection();
			statement = DaoUtils.initStatement(connection, "SELECT * FROM news WHERE id = ?", false, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				news = map(resultSet);
			}
		}
		catch (SQLException e) {
			throw new DaoException(e);
		}
		finally {
			DaoUtils.closeParams(statement, connection, resultSet);
		}
		return news;
	}

	private static NewsBean map(ResultSet resultSet) throws SQLException {
		NewsBean news = new NewsBean();
		news.setId(resultSet.getLong("id"));
		news.setUserEmail(resultSet.getString("userEmail"));
		news.setContent(resultSet.getString("content"));
		news.setDate(resultSet.getString("date"));
		return news;
	}
}
