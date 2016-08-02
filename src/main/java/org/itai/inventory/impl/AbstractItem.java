package org.itai.inventory.impl;

import org.itai.inventory.Item;

public abstract class AbstractItem implements Item
{
	private static long LAST_ID = -1;

	private long id;

	public AbstractItem()
	{
		this.id = this.nextId();
	}

	public long getId()
	{
		return this.id;
	}

	private long nextId()
	{
		long id = LAST_ID;
		LAST_ID++;
		return id;
	}
}
