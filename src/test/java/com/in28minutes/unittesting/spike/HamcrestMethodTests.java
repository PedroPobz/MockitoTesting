package com.in28minutes.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;


import org.junit.jupiter.api.Test;

class HamcrestMethodTests {

	@Test
	void learning() {
		List<Integer> numbers = Arrays.asList(12, 15, 45);
		
//		assertThat(numbers, hasSize(3));
//		assertThat(numbers, hasItems(12, 45));
//		assertThat(numbers, everyItem(greaterThan(10)));
		
		assertThat(numbers)
			.hasSize(3)
			.contains(12, 45)
			.allMatch(i -> i > 10);
		
	}

}
