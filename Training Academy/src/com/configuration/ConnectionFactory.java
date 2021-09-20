package com.configuration;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class ConnectionFactory {
	static final String URL="jdbc:mysql://localhost:3306/databse1";
	static final String USER="root";
	static final String PASS="root";
	
	public   Connection getConnection() throws SQLException
	{
		Connection connection=null;
		connection=DriverManager.getConnection(URL,USER,PASS);
		return connection;
	}

}



