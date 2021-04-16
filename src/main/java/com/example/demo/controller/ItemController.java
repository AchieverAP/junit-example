package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1,"ball",10,100);
	}

	@GetMapping("/item-from-bussiness-service")
	public Item itemFrombussinessSerivce() {
		
		 return itemService.retriveHardcodedItem();
		 
	}
	
	@GetMapping("/all-item-from-db")
	public List<Item> itemFromDb() {
		
		 return itemService.retriveAllItems();
		 
	}

	
}
