package com.jweb.dao;

import com.jweb.beans.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
	private DaoFactory daoFactory;

	UserDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public UserBean find(String email) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserBean user = null;

		try {
			connection = daoFactory.getConnection();
			statement = DaoUtils.initStatement(connection, "SELECT * FROM user WHERE email = ?", false, email);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = map(resultSet);
			}
		}
		catch (SQLException e) {
			throw new DaoException(e);
		}
		finally {
			DaoUtils.closeParams(statement, connection, resultSet);
		}
		return user;
	}

	private static final String SQL_INSERT = "INSERT INTO user (email, password, name) VALUES (?, ?, ?)";

	@Override
	public void create(UserBean user) throws IllegalArgumentException, DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = daoFactory.getConnection();
			statement = DaoUtils.initStatement(connection, SQL_INSERT, true, user.getEmail(), user.getPassword(), user.getName());
			int status = statement.executeUpdate();
			if (status == 0) {
				throw new DaoException("Failed to add a new user, no line added in table");
			}
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
//				user.setId(resultSet.getLong(1));
			}
			else {
				throw new DaoException("Failed to add a new user, no ID generated");
			}

		}
		catch (SQLException e) {
			throw new DaoException(e);
		}
		finally {
			DaoUtils.closeParams(statement, connection, resultSet);
		}

	}

	private static UserBean map(ResultSet resultSet) throws SQLException {
		UserBean user = new UserBean();
//		user.setId(resultSet.getLong("id"));
		user.setEmail(resultSet.getString("email"));
		user.setName(resultSet.getString("name"));
//		user.setSurname(resultSet.getString("surname"));
		user.setPassword(resultSet.getString("password"));
		return user;
	}
}
