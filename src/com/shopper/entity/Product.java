package com.shopper.entity;

/**
 * This class contains all the data fields present in table Product. It is
 * used to generate a bean form of a tuple from product
 * 
 * @author 1021124
 *
 */
public class Product
{
	private String id;
	private String name;
	private String manufacturer;
	private double price;
	private String category;

	
	
	public Product()
	{
		super();
	}

	public Product(String id, String name, String manufacturer, double price,
			String category)
	{
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
	}

	/**
	 * @return id of the product
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * Sets the id of a product
	 * @param id value of id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * @return name of the product
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of a product
	 * @param name string containing name of the product
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * 
	 * @return manufacturer company of the product
	 */
	public String getManufacturer()
	{
		return manufacturer;
	}

	/**
	 * Sets the manufacturer of the product
	 * @param manufacturer string containing name of the manufacturer
	 */
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	/**
	 * @return price of the product in double format
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Sets the price of the product
	 * @param price double value describing price of the product
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/**
	 * 
	 * @return category of the product to which it belongs
	 */
	public String getCategory()
	{
		return category;
	}

	/**
	 * Sets the category of the product
	 * e.g. grocery, daily-use, electronics etc.
	 * @param category string containing name of the category
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}

	@Override
	public String toString()
	{
		return "ProductBean [id=" + id + ", name=" + name + ", manufacturer="
				+ manufacturer + ", Price=" + price + ", category=" + category
				+ "]";
	}
	
	

}