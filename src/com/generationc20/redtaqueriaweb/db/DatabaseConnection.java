package com.generationc20.redtaqueriaweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String JDBC_URL_FORMAT = "jdbc:%s://%s:%s/%s";
	
	public static Connection getConnection() {
		
		String dbms = "mysql";
		String host = "localhost";
		String port = "3306";
		String databaseName = "red_taqueria";
		String url = String.format(JDBC_URL_FORMAT, dbms, host, port, databaseName);
		String user = "root";
		String password = "root";
		
		Connection connection = null;
		
		try {
			//Registrar driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
	
	return connection;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
