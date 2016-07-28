package com.shopper.entity;

public class Shop
{
	private String id;
	private String owner;
	private String address;
	private String contact;

	
	
	public Shop()
	{}

	public Shop(String id, String owner, String address, String contact)
	{
		this.id = id;
		this.owner = owner;
		this.address = address;
		this.contact = contact;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getContact()
	{
		return contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}

}
