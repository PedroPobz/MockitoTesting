package com.in28minutes.unittesting.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.in28minutes.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;
	
	@Test
	void testFindAll() {
		List<Item> items = repository.findAll();
		
		assertEquals(3, items.size());
			
	}

}
