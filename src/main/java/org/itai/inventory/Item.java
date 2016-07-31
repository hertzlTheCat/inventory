package org.itai.inventory;

public interface Item {

	long getId();
	
	String getDescription();
	
	int getQuantity();
	
	void setDiscarded();
	
	boolean isDiscarded();
}
