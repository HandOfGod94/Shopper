package com.shopper.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shopper.entity.Shop;

/**
 * Responsible for performing all the CRUD operations on 
 * Shop table of the database.
 * @author 1021124
 *
 */
public class ShopCRUD
{
	private static Connection conn = ConnectionManager.getConnection();
	private static String query = null;
	
	/**
	 * Fetches the shop details from the database and
	 * add it to ArrayList<Shop>
	 * @return list of all the shops with their details
	 */
	public static ArrayList<Shop> read()
	{
		ArrayList<Shop> shopList = new ArrayList<Shop>();
		query = "SELECT * FROM shop;";
		
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet set = stmnt.executeQuery(query);
			
			while(set.next());
			{
				Shop shop = new Shop();
				shop.setId(set.getString("id"));
				shop.setOwner(set.getString("owner"));
				shop.setAddress(set.getString("address"));
				shop.setContact(set.getString("contact"));
				shopList.add(shop);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return shopList;
	}
	
	/**
	 * Fetches a specific shop based on the shop id
	 * @param id String containg id of the shop
	 * @return Shop object as obtained from db if success,
	 * 	null otherwise
	 */
	public static Shop read(String id)
	{
		query = "SELECT * FROM shop WHERE id = \'" + id +"\'";
		Shop shop = new Shop();
		
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);
			if(resultSet.next())
			{
				shop.setId(resultSet.getString("id"));
				shop.setAddress(resultSet.getString("address"));
				shop.setContact(resultSet.getString("contact"));
				shop.setOwner(resultSet.getString("owner"));
			}
			else
				throw new SQLException();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return shop;
	}
}
