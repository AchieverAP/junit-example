package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.ItemRepository;
import com.example.demo.modal.Item;

@Service
public class ItemService {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	public Item retriveHardcodedItem() {
		
		return new Item(1, "Ball", 1, 100);
	}
	
	
	public List<Item> retriveAllItems(){
	
		 List<Item> items = itemRepository.findAll();
		logger.info("initial {}",items);
		 for(Item item:items) {
			 
			 item.setValue(item.getQuantity()*item.getPrice());
		 }
		 
		 logger.info("final {}",items);
		 return items;
	}
}
