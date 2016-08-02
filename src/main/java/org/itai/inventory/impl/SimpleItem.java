package org.itai.inventory.impl;

public class SimpleItem extends AbstractItem
{
	private String description;
	private int quantity;
	private boolean discarded;
	
	public SimpleItem(String description, int quantity)
	{
		this.description = description;
		this.quantity = quantity;
		this.discarded = false;
	}
	
	public String getDescription() 
	{
		return this.description;
	}

	public int getQuantity() 
	{
		return this.quantity;
	}

	public void setDiscarded() 
	{
		this.discarded = true;
	}

	public boolean isDiscarded() 
	{
		return this.discarded;
	}

}
