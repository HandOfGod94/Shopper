package com.shopper.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

import com.shopper.entity.UserComment;

/**
 * This class performs all the CRUD (Create,Read,Update,Delete) operations on
 * user_comment schema defined in shopper_db.
 * 
 * @author 1021124
 *
 */
public class UserCommentCRUD
{
	private static Connection conn = null;
	private static String query = null;

	/**
	 * Performs insertion on table user_comment with help of UserCommentBean
	 * 
	 * @param userComment
	 *            UserComment containing the required data of user comment
	 * @return true - if insertion successful <br>
	 *         false - otherwise
	 */
	public static boolean insert(UserComment userComment)
	{
		conn = ConnectionManager.getConnection();
		query = "INSERT INTO user_comment " + "VALUES (" + userComment.getId()
				+ "," + "\'" + userComment.getProductId() + "\',"
				+ userComment.getRating() + "," + "\'"
				+ userComment.getComment() + "\')";
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

	/**
	 * Reads rating and user comments from user_comment table and stores it in
	 * form of pairs in a list
	 * 
	 * @param productId
	 *            id of the product
	 * @return {@link ArrayList} of SimpleEntry with rating and comment as its
	 *         key and value
	 */
	public static ArrayList<SimpleEntry<Integer, String>> read(String productId)
	{
		ArrayList<SimpleEntry<Integer, String>> comments = new ArrayList<>();
		int rating;
		String comment;
		conn = ConnectionManager.getConnection();
		query = "SELECT * FROM user_comment WHERE product_id = \'" + productId
				+ "\'";

		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);

			while (resultSet.next())
			{
				rating = resultSet.getInt("rating");
				comment = resultSet.getString("comments").toLowerCase();
				comments.add(new SimpleEntry<>(rating, comment));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return comments;
	}

	/**
	 * Traverses user comment table and returns distinct product ids present in
	 * it
	 * 
	 * @return {@link ArrayList} of String containing product ids.
	 */
	public static ArrayList<String> getDistinctProductIds()
	{
		ArrayList<String> productIds = new ArrayList<String>();
		conn = ConnectionManager.getConnection();
		query = "SELECT DISTINCT product_id FROM user_comment;";

		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);

			while (resultSet.next())
			{
				productIds.add(resultSet.getString("product_id"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return productIds;
	}
}
