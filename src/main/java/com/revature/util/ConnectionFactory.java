package com.revature.util;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {
	
private static ConnectionFactory cf = new ConnectionFactory(1);
	
	//provide a single point of access to the connection factory
	public static ConnectionFactory getConnectionFactory() {
		return cf;
	}
	
	
	//this holds all of our connections
	//we could potential implement this as a connection pool
	private Connection [] conn;
	
	//this is a very basic factory
	//only a single param for configuration
	//if we are making a singleton
	//all of our constructores must be private
	//otherwise others could make new instances
	private ConnectionFactory(int numberOfConnections) {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//if we were gonna implement for real
	//we would want to synchronize for multiple threads
	//add locks and .wait and .notify
	//I'm going to pretend only thread exists
	//and we will only ever need a single connection
	public Connection getConnection() {
		//TODO
		return this.conn[0];
	}
	
	public void releaseConnection(Connection conn) {
		//TODO
	}

}
