package com.shopper.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.shopper.entity.UserComment;

/**
 * This class performs all the CRUD (Create,Read,Update,Delete)
 * operations on user_comment schema defined in shopper_db.
 * @author 1021124
 *
 */
public class UserCommentCRUD
{
	private static Connection conn = null;
	private static String query = null;
	
	/**
	 * Performs insertion on table user_comment with 
	 * help of UserCommentBean
	 * @param userComment UserComment containing the required data of user comment
	 * @return
	 * 	true - if insertion successful <br>
	 * 	false - otherwise
	 */
	public static boolean insert(UserComment userComment)
	{
		conn = ConnectionManager.getConnection();
		query = "INSERT INTO user_comment " +
				"VALUES ("+
						userComment.getId() + ","+
						 "\'"+userComment.getProductId() + "\'," +
						userComment.getRating() + "," + 
						"\'"+ userComment.getComment() + "\')";
		try
		{
			Statement stmnt = conn.createStatement();
			stmnt.execute(query);
		} catch (SQLException e)
		{
			return false;
		}
		return true;
	}
}
