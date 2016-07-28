package com.shopper.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shopper.entity.Shop;

public class ShopCRUD
{
	private static Connection conn = ConnectionManager.getConnection();
	private static String query = null;
	
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
