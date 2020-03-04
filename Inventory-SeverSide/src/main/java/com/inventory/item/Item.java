package com.inventory.item;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Item {

	@ApiModelProperty(notes= "the unique id number of the item")
	@Id
	private int number;
	@ApiModelProperty(notes= "the name of the item")
	private String name;
	@ApiModelProperty(notes= "the amount of the item")
	private int amount;
	@ApiModelProperty(notes= "the inventory code of the item")
	private String inventoryCode;
	
	 
	public Item() {
	}
	
	public Item(int number, String name, int amount, String inventoryCode) {
		super();
		this.number = number;
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getInventoryCode() {
		return inventoryCode;
	}
	
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	
}
