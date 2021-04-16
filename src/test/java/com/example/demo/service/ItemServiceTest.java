package com.example.demo.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import java.util.List;

import javax.annotation.security.RunAs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import com.example.demo.controller.ItemController;
import com.example.demo.data.ItemRepository;
import com.example.demo.modal.Item;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

	
	
	 @Mock
	 ItemRepository mockItemRepository;
	
	 @InjectMocks
     ItemService itemService;
	 
	
	 @Test
	 public void retriveAllItemTest_Basic() {
		 when(mockItemRepository.findAll()).thenReturn(Arrays.asList(new Item(2,"all",10,100),new Item(3,"ball",100,101)));
		 List<Item> items = itemService.retriveAllItems();
		 assertEquals(1000,items.get(0).getValue());
		 assertEquals(10100,items.get(1).getValue());
	 }
	
}
