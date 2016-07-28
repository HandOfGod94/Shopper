package com.shopper.entity;

public class ShoppingData
{	
	private String productId;
	private String productName;
	private int returnQuantity;
	private float salePercent;
	private String saleCategory;
	
	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public int getReturnQuantity()
	{
		return returnQuantity;
	}

	public void setReturnQuantity(int returnQuantity)
	{
		this.returnQuantity = returnQuantity;
	}

	public float getSalePercent()
	{
		return salePercent;
	}

	public void setSalePercent(float salePercent)
	{
		this.salePercent = salePercent;
	}

	public String getSaleCategory()
	{
		return saleCategory;
	}

	public void setSaleCategory(String saleCategory)
	{
		this.saleCategory = saleCategory;
	}

	@Override
	public String toString()
	{
		return "ShoppingData [productId=" + productId + ", productName="
				+ productName + ", returnQuantity=" + returnQuantity
				+ ", salePercent=" + salePercent + ", saleCategory="
				+ saleCategory + "]";
	}

	
}
