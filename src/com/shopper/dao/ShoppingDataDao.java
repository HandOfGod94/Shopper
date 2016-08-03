package com.shopper.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;

import com.shopper.entity.Product;
import com.shopper.entity.SaleCategory;
import com.shopper.entity.ShoppingData;

public class ShoppingDataDao
{
	private static Connection conn = null;
	private static String query = null;

	/**
	 * Reads the list of products in a shop
	 * 
	 * @param shopId
	 *            Id of the shop for which querying is needed
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

			while (resultSet.next())
			{
				ShoppingData data = fillShoppingData(resultSet);
				list.add(data);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Updates the sale records. These are generally sale or return requests
	 * encountered by the shopkeeper. It updates the left and return quantity of
	 * the table
	 * 
	 * @param productId
	 *            id of the product which is currently being returned or sold
	 * @param shopId
	 *            id of the shop where this transaction is taking place
	 * @param quantity
	 *            number of items sold/returned
	 * @param transactionType
	 *            enum int, type of transaction whether sale or return. Refer
	 *            See Also.
	 * @see {@link TransactionType} for enum type integer values.
	 * @return true, if successfully updated; <br>
	 *         false, otherwise.
	 */
	public static boolean update(String productId, String shopId, int quantity,
			int transactionType)
	{
		conn = ConnectionManager.getConnection();
		query = "UPDATE shopping_data "
				+ " SET left_quantity = left_quantity - ?,"
				+ "		return_quantity = return_quantity + ?  "
				+ " WHERE product_id = \'" + productId + "\' "
				+ " AND shop_id = \'" + shopId + "\';";

		try
		{
			PreparedStatement stmnt = conn.prepareStatement(query);
			switch (transactionType)
			{
				case TransactionType.SALE:
					stmnt.setInt(1, quantity);
					stmnt.setInt(2, 0);
					break;
				case TransactionType.RETURN:
					stmnt.setInt(1, (-1 * quantity));
					stmnt.setInt(2, quantity);
					break;
				default:
					break;
			}
			stmnt.execute();
			return true;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Calculates maximum selling product from all the stores. It will remain
	 * common throughout all the stores
	 * 
	 * @return object of {@link Product} whose sale is maximum
	 */
	public static Product getOverallMaxSoldProduct()
	{
		conn = ConnectionManager.getConnection();
		query = "SELECT product_id, SUM(init_quantity)-SUM(left_quantity) AS sold"
				+ " FROM shopper.shopping_data"
				+ " GROUP BY product_id"
				+ " ORDER BY sold DESC" + " LIMIT 0,1;";

		Product product = null;
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);
			if (resultSet.next())
			{
				String productId = resultSet.getString("product_id");
				product = ProductCRUD.read(productId);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}

	/**
	 * Fill up the shopping data from ResultSet
	 * 
	 * @param resultSet
	 *            ResultSet obtained from execution of current query
	 * @return {@link ShoppingData} object with all the values filled
	 *         accordingly
	 * @throws SQLException
	 */
	private static ShoppingData fillShoppingData(ResultSet resultSet)
			throws SQLException
	{
		float salePercent;
		int initQuantity, leftQuantity;
		String saleCategory;

		ShoppingData data = new ShoppingData();

		data.setProductId(resultSet.getString("id"));
		data.setProductName(resultSet.getString("name"));
		data.setReturnQuantity(resultSet.getInt("return_quantity"));

		initQuantity = resultSet.getInt("init_quantity");
		leftQuantity = resultSet.getInt("left_quantity");
		salePercent = 100.00F * (((float) initQuantity - (float) leftQuantity) / (float) initQuantity);

		data.setSalePercent(salePercent);

		if (salePercent >= SaleCategory.HIGH_SALE_LOWER_BOUND)
			saleCategory = SaleCategory.SALE_CATEGORY_HIGH;
		else if (salePercent < SaleCategory.HIGH_SALE_LOWER_BOUND
				&& salePercent >= SaleCategory.MEDIUM_SALE_LOWER_BOUND)
			saleCategory = SaleCategory.SALE_CATEGORY_MEDIUM;
		else
			saleCategory = SaleCategory.SALE_CATEGORY_LOW;
		data.setSaleCategory(saleCategory);

		return data;
	}

	public static TreeMap<String, Integer> getProductSalePairs(String shopId)
	{
		conn = ConnectionManager.getConnection();
		query = "SELECT product.id,product.name, "
				+ "sum(shopping_data.left_quantity) AS left_quant, "
				+ "sum(init_quantity) AS init_quant"
				+ " FROM product,shopping_data"
				+ " WHERE product.id = shopping_data.product_id"
				+ " AND shopping_data.shop_id = \'" + shopId + "\'"
				+ " GROUP BY shopping_data.product_id;";
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		try
		{
			Statement stmnt = conn.createStatement();
			ResultSet resultSet = stmnt.executeQuery(query);

			while (resultSet.next())
			{
				// Product name
				String key = resultSet.getString("name");
				// Product sale
				int value = resultSet.getInt("init_quant")
						- resultSet.getInt("left_quant");
				map.put(key, value);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return map;
	}
}
