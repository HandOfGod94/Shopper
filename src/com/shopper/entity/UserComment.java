package com.shopper.entity;

/**
 * This class contains all the data fields present in table user_comment. It is
 * used to generate a bean form of a tuple from user_comment
 * 
 * @author 1021124
 *
 */
public class UserComment
{
	private int id=0;
	private String productId;
	private int rating;
	private String comment;
	
	/**
	 * @return product id of the product
	 */
	public String getProductId()
	{
		return productId;
	}
	
	/**
	 * Sets the product id with given string value
	 * @param productId String
	 */
	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	/**
	 * @return rating of a particular product given
	 * by user
	 */
	public int getRating()
	{
		return rating;
	}

	/**
	 * Sets rating of a product with specific product ID.
	 * @param rating int
	 */
	public void setRating(int rating)
	{
		this.rating = rating;
	}

	/**
	 * @return Comment made by the user on a specific product
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * Sets the comment on a specific product made by the user
	 * @param comments String
	 */
	public void setComment(String comments)
	{
		this.comment = comments;
	}

	/**
	 * @return ID of the product
	 */
	public int getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return "UserCommentBean [id=" + id + ", productId=" + productId
				+ ", rating=" + rating + ", comment=" + comment + "]";
	}
	
	

}
