package com.jweb.dao;

import com.jweb.beans.CommentBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDaoImpl implements CommentDao{
	private DaoFactory daoFactory;

	CommentDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public CommentBean find(String email) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		CommentBean comment = null;

		try {
			connection = daoFactory.getConnection();
			statement = DaoUtils.initStatement(connection, "SELECT * FROM comment WHERE email = ?", false, email);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				comment = map(resultSet);
			}
		}
		catch (SQLException e) {
			throw new DaoException(e);
		}
		finally {
			DaoUtils.closeParams(statement, connection, resultSet);
		}
		return comment;
	}

	private static final String SQL_INSERT = "INSERT INTO comment (content, date, user, email) VALUES (?, ?, ?, ?)";

	@Override
	public void create(CommentBean comment) throws IllegalArgumentException, DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection();
			statement = DaoUtils.initStatement(connection, SQL_INSERT, true, comment.getComment(), comment.getDate(), comment.getName(), comment.getEmail());
			int status = statement.executeUpdate();
			if (status == 0) {
				throw new DaoException("Failed to add a new comment, no line added in table");
			}
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
//				comment.setId(resultSet.getLong(1));
			}
			else {
				throw new DaoException("Failed to add a new comment, no ID generated");
			}

		}
		catch (SQLException e) {
			throw new DaoException(e);
		}
		finally {
			DaoUtils.closeParams(statement, connection, resultSet);
		}

	}

	private static CommentBean map(ResultSet resultSet) throws SQLException {
		CommentBean comment = new CommentBean();
//		comment.setId(resultSet.getLong("id"));
		comment.setEmail(resultSet.getString("email"));
		comment.setName(resultSet.getString("user"));
		comment.setComment(resultSet.getString("content"));
		comment.setDate(resultSet.getString("date"));
		return comment;
	}
}
