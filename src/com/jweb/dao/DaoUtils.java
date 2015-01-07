package com.jweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtils {
	public static PreparedStatement initStatement(Connection connexion, String sql, boolean returnKeys, Object... objects) throws SQLException {
		PreparedStatement statement = connexion.prepareStatement(sql, returnKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
	    for (int i = 0; i < objects.length; i++) {
	    	statement.setObject(i + 1, objects[i]);
	    }
	    return statement;
	}
	    
	public static void closeParam(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			}
			catch (SQLException e) {
				System.out.println("Failed to close resultSet : " + e.getMessage());
			}
		}
	}

	public static void closeParam(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			}
			catch (SQLException e) {
				System.out.println("Failed to close statement : " + e.getMessage());
			}
		}
	}

	public static void closeParam(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			}
			catch (SQLException e) {
				System.out.println("Failed to close connection : " + e.getMessage());
			}
		}
	}

	public static void closeParams(Statement statement, Connection connection) {
		closeParam(statement);
		closeParam(connection);
	}

	public static void closeParams(Statement statement, Connection connection, ResultSet resultSet) {
		closeParam(resultSet);
		closeParam(statement);
		closeParam(connection);
	}
}
