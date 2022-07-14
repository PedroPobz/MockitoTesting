package com.in28minutes.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.model.Item;

@ExtendWith(MockitoExtension.class) 
class ItemBusineesServiceTEst {

	@Mock
	ItemRepository repository;
	
	@InjectMocks
	ItemBusinessService itemBusinessService;
	
	@Test
	public void retrieveAllItems_basic() {
		
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1, "Item1", 10, 10));
		itemList.add(new Item(2, "Item2", 20, 20));
		itemList.add(new Item(3, "Item3", 30, 30));
		itemList.add(new Item(4, "Item4", 40, 40));
		
		when(repository.findAll()).thenReturn(itemList);
		
		itemBusinessService.retrieveAllItems();

		itemList.stream().forEach((item) -> assertEquals(item.getValue(), item.getPrice()*item.getQuantity()));
	}
	
	@Test
	public void retrieveAllItems_emptyList() {
		
		List<Item> itemList = new ArrayList<>();
		
		when(repository.findAll()).thenReturn(itemList);
		
		itemBusinessService.retrieveAllItems();

		itemList.stream().forEach((item) -> assertEquals(item.getValue(), item.getPrice()*item.getQuantity()));
	}
	
	@Test
	public void retrieveAllItems_oneItem() {
		
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1, "Item1", 10, 10));
		
		when(repository.findAll()).thenReturn(itemList);
		
		itemBusinessService.retrieveAllItems();

		itemList.stream().forEach((item) -> assertEquals(item.getValue(), item.getPrice()*item.getQuantity()));
	}

}
