package com.inventory.item;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin
public class ItemController {

	@Autowired
	private ItemService itemService; 
	

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	@ApiOperation(value = "Get all items from the inventory")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	@ApiOperation(value = "Add a new item to the inventory")
	public void addItem(@RequestBody Item item) {
		itemService.addItem(item);
	}
	
	
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Find item by number id",
				notes="Provide a number id to look up for specific item from the invertory",
				response = Item.class)
	public Item getItem(@PathVariable int id) {
		return itemService.getItem(id);
	}
	
	
	@RequestMapping(value = "/items/{id}/deposit", method = RequestMethod.PUT)
	@ApiOperation(value = "Deposit quantity of specific item to the invertory",
				notes="Provide a number id and the amount to deposit")
	public void depositQuantityOfItem(@PathVariable int id, @RequestParam("amount") String amount) {
        if (amount!= null && amount.matches("[0-9]+")) {
        	int amountToAdd = Integer.parseInt(amount);
        	itemService.depositQuantityOfItem(id, amountToAdd);
        }
	}
	

	@RequestMapping(value = "/items/{id}/withdrawal", method = RequestMethod.PUT)
	@ApiOperation(value = "Withdrawal quantity of specific item from the invertory",
				notes="Provide a number id and the amount to withdrawal")
	public void withdrawalQuantityOfItem(@PathVariable int id, @RequestParam("amount") String amount) {
        if (amount!= null && amount.matches("[0-9]+")) {
        	int amountToAdd = Integer.parseInt(amount);
        	itemService.withdrawalQuantityOfItem(id, amountToAdd);
        }
	}
	
	
	@RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Item by number id",
				notes="Provide a number id to delete a specific item from the invertory")
	public void deleteItem(@PathVariable int id) {
		itemService.deleteItem(id);
	}
	

	
} 

