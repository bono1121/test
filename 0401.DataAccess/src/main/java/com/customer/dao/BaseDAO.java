package com.customer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO implements DAO {
	
	@Autowired
	private DataSource dataSource;

	//db 연결 커넥션 객체 리턴해 주는 메소드 
	public Connection getConnection() {

		Connection connection = null;

		try {
			
			connection = dataSource.getConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return connection;

	}

	//db 연결 해제 메소드
	protected void closeDBObjects(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}
}