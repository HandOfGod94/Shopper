package com.shopper.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class establishes and mangages connection between
 * java servlet and MySql Database.
 * @author 1021124
 *
 */
public class ConnectionManager
{

	static Connection con;
	static String url;

	/**
	 * Establishes a connection between servlet and 
	 * db(shopper).
	 * @return instance of {@link java.sql.Connection} if successfull else null
	 */
	public static Connection getConnection()
	{

		try
		{
			String url = "jdbc:mysql://localhost/shopper";

			Class.forName("com.mysql.jdbc.Driver");

			try
			{
				con = DriverManager.getConnection(url, "root", "password");
			}

			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}

		catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}

		return con;
	}
}