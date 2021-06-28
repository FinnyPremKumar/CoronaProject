package com.virusDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection 
{
	public static Connection getMyDbConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
	}
}
