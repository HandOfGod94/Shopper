package com.shopper.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shopper.entity.Product;
import com.shopper.entity.SaleCategory;
import com.shopper.entity.ShoppingData;

public class ShoppingDataDao
{
	private static Connection conn = null;
	private static String query = null;

	/**
	 * Reads the list of products in a shop
	 * @param shopId Id of the shop for which querying is needed
	 * @return {@link ArrayList} of products
	 */
	public static ArrayList<ShoppingData> read(String shopId)
	{
		ArrayList<ShoppingData> list = new ArrayList<ShoppingData>();
		
		conn = ConnectionManager.getConnection();
		query = "SELECT product.id,product.name,"
				+ "shopping_data.product_id, shopping_data.shop_id,"
				+ "shopping_data.init_quantity,shopping_data.left_quantity,"
				+ "shopping_data.return_quantity"
					+ " FROM product,shopping_data"
					+ " WHERE shopping_data.shop_id=\'" + shopId + "\'"
					+ " AND product.id=shopping_data.product_id;";
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);
			
			while(resultSet.next())
			{
				ShoppingData data = fillShoppingData(resultSet);
				list.add(data);
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public static Product getOverallMaxSoldProduct()
	{
		conn = ConnectionManager.getConnection();
		query = "SELECT product_id, SUM(init_quantity)-SUM(left_quantity) AS sold"
				+ " FROM shopper.shopping_data"
				+ " GROUP BY product_id"
				+ " ORDER BY sold DESC"
				+ " LIMIT 0,1;";
		
		Product product = null;
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);
			if (resultSet.next())
			{	String productId = resultSet.getString("product_id");
				product = ProductCRUD.read(productId);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}
	
	private static ShoppingData fillShoppingData(ResultSet resultSet) throws SQLException
	{
		float salePercent;
		int initQuantity,leftQuantity;
		String saleCategory;
		
		ShoppingData data = new ShoppingData();
		
		data.setProductId(resultSet.getString("id"));
		data.setProductName(resultSet.getString("name"));
		data.setReturnQuantity(resultSet.getInt("return_quantity"));
		
		initQuantity = resultSet.getInt("init_quantity");
		leftQuantity = resultSet.getInt("left_quantity");
		salePercent = 100.00F * (((float)initQuantity-(float)leftQuantity) / (float) initQuantity);
		
		data.setSalePercent(salePercent);
		
		if (salePercent>=SaleCategory.HIGH_SALE_LOWER_BOUND)
			saleCategory = SaleCategory.SALE_CATEGORY_HIGH;
		else if (salePercent<SaleCategory.HIGH_SALE_LOWER_BOUND && salePercent>=SaleCategory.MEDIUM_SALE_LOWER_BOUND)
			saleCategory = SaleCategory.SALE_CATEGORY_MEDIUM;
		else
			saleCategory = SaleCategory.SALE_CATEGORY_LOW;
		data.setSaleCategory(saleCategory);
		
		return data;
	}
}
