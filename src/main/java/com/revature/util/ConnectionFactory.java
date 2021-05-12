package com.revature.util;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {
	
private static ConnectionFactory cf = new ConnectionFactory(1);
	
	
	public static ConnectionFactory getConnectionFactory() {
		return cf;
	}
	
	private Connection [] conn;
	private ConnectionFactory(int numberOfConnections) {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		final String url = "jdbc:postgresql://rev-can-training.c5sk74x2lolp.us-east-2.rds.amazonaws.com:5432/ersdb";
		final String user = "ersuser";
		final String password = "Passw0rd";
		try {
			this.conn = new Connection[numberOfConnections];
			for(int i = 0; i< this.conn.length; i++) {
				Connection conn = DriverManager.getConnection(url, user, password);
				this.conn[i] = conn;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		
	public Connection getConnection() {
	
		return this.conn[0];
	}
	
	public void releaseConnection(Connection conn) {
		
	}

}
