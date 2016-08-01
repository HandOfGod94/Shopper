package com.shopper.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shopper.entity.Product;

public class ProductCRUD
{
	private static Connection conn = null;
	private static String query = null;
	private static ArrayList<Product> arrayList;

	/**
	 * @return list of all the Products in object form
	 */
	public static ArrayList<Product> read()
	{
		conn = ConnectionManager.getConnection();
		query = "SELECT * FROM product";
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);
			if (arrayList == null)
			{
				arrayList = new ArrayList<Product>();
				while (resultSet.next())
				{
					Product bean = new Product();
					bean.setId(resultSet.getString("id"));
					bean.setName(resultSet.getString("name"));
					bean.setManufacturer(resultSet.getString("manufacturer"));
					bean.setPrice(resultSet.getDouble("price"));
					bean.setCategory(resultSet.getString("category"));
					arrayList.add(bean);
				}
			}
			return arrayList;

		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static Product read(String productId)
	{
		conn = ConnectionManager.getConnection();
		query = "SELECT * FROM product WHERE id = \'" + productId + "\'";
		Product product = new Product();
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);
			if (resultSet.next())
			{
				
				product.setId(resultSet.getString("id"));
				product.setName(resultSet.getString("name"));
				product.setManufacturer(resultSet.getString("manufacturer"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
			}
			return product;

		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
