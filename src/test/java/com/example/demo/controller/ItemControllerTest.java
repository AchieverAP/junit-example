package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.modal.Item;
import com.example.demo.service.ItemService;


@WebMvcTest( ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ItemService mockItemService;
	
	@Test
	public void dummyItem_basic() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
	    MvcResult result= mockMvc.perform(request)
	    		.andExpect(status().isOk())
	    		.andExpect(content().json("{\"id\":1,\"name\":\"ball\",\"price\":10}"))
	    		.andReturn();
	    //assertEquals("Hello-World",result.getResponse().getContentAsString());
	}
	
	@Test
	public void itemFromussinessService_basic() throws Exception {
		
		when(mockItemService.retriveHardcodedItem()).thenReturn(new Item(2, "all", 10, 100));
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-bussiness-service")
				.accept(MediaType.APPLICATION_JSON);
	    MvcResult result= mockMvc.perform(request)
	    		.andExpect(status().isOk())
	    		.andExpect(content().json("{id:2,name:all,price:10,quantity:100}"))
	    		.andReturn();
	    //assertEquals("Hello-World",result.getResponse().getContentAsString());
	}
	
	@Test
	public void itemfromDB_basic() throws Exception {
		
		when(mockItemService.retriveAllItems()).thenReturn(Arrays.asList(new Item(2,"all",10,100),new Item(3,"ball",100,101)));
		RequestBuilder request = MockMvcRequestBuilders.get("/all-item-from-db")
				.accept(MediaType.APPLICATION_JSON);
	    MvcResult result= mockMvc.perform(request)
	    		.andExpect(status().isOk())
	    		.andExpect(content().json("[{id:2,name:all,price:10,quantity:100},{id:3,name:ball,price:100,quantity:101}]"))
	    		.andReturn();
	    //assertEquals("Hello-World",result.getResponse().getContentAsString());
	}	
	
	
}

