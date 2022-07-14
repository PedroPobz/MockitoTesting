package com.in28minutes.unittesting.business;

import java.util.stream.IntStream;

import com.in28minutes.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	SomeDataService someDataService;

	public int calculateSum(int[] data) {
		
		return IntStream.of(data).sum();
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSumUsingDataService() {
		int[] data = someDataService.retrieveAllData();
		
		return IntStream.of(data).sum();
	}
}
