package com.in28minutes.unittesting.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.model.Item;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	 private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	void dummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":  1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
	}

	@Test
	void itemFromBusinessService_basic() throws Exception {
		
		when(businessService.retrieveHardcodedItem()).thenReturn(
				new Item(2, "Item2", 10, 10)
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2, name:Item2, price:10, quantity:10}"))
				.andReturn();
	}

	@Test
	public void retrieveAllItems_basic() throws Exception {
		
//		doReturn(Arrays.asList(new Item[] {new Item(2, "Item2", 10, 10)})).when(businessService.retrieveAllItems());
		
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(2, "Item2", 10, 10));
		itemList.add(new Item(3, "Item3", 20, 20));
		
		when(businessService.retrieveAllItems()).thenReturn(itemList);
		
//		when(businessService.retrieveAllItems()).thenReturn(
//				Arrays.asList(new Item(2, "Item2", 10, 10))
//				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2, name:Item2, price:10, quantity:10}, {id:3, name:Item3, price:20, quantity:20}]"))
				.andReturn();
	}
}
