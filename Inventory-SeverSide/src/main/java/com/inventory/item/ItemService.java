package com.inventory.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	public List<Item> getAllItems(){
		List<Item> items = new ArrayList<>();
		itemRepository.findAll()
		.forEach(items::add);
		return items;
	}
	
	
	public Item getItem(int id){
		return itemRepository.findById(id).orElse(null);
		
	}
	
	
	public void addItem(Item item){
		itemRepository.save(item);
	}
	
	
	public void deleteItem(int id){
		itemRepository.deleteById(id);
	}
	
	
	public void withdrawalQuantityOfItem(int id, int withdrawalAmount) {
		Item item = itemRepository.findById(id).orElse(null);
		if (item!=null) {
			int newAmount = item.getAmount() - withdrawalAmount;
			if (newAmount>=0) {
				item.setAmount(newAmount);
				itemRepository.save(item);
			}		
		}
	}
	
	
	public void depositQuantityOfItem(int id, int depositAmount) {
		Item item = itemRepository.findById(id).orElse(null);
		if (item!=null && depositAmount>0) {
			item.setAmount(item.getAmount() + depositAmount);
			itemRepository.save(item);	
		}
	}
}
