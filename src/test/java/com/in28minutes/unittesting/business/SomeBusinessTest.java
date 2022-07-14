package com.in28minutes.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.data.*;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}
	
}


@ExtendWith(MockitoExtension.class) 
class SomeBusinessTest {
	
	@Mock
	SomeDataService someDataService;
	
	@InjectMocks
	SomeBusinessImpl business;
//
//	@Test
//	void calculateSum_basic() {
//		SomeBusinessImpl business = new SomeBusinessImpl();
//		
//		int intArray[] = mock(new int[] {});
//		
//		assertThat(business.calculateSum(new int[] {1, 2, 3}), is(6));
//	}
//
//	@Test
//	void calculateSum_empty() {
//		SomeBusinessImpl business = new SomeBusinessImpl();
//		
//		assertThat(business.calculateSum(new int[] {}), is(0));
//	}
//	
//	@Test
//	void calculateSum_oneValue() {
//		SomeBusinessImpl business = new SomeBusinessImpl();
//		
//		assertThat(business.calculateSum(new int[] {1}), is(1));
//	}
	
	@Test
	void calculateSumUsingDataService_basic() {

		business.setSomeDataService(someDataService);
		
//		when(someDataService.retrieveAllData()).thenReturn(new int[] {1,2,3});
		given(someDataService.retrieveAllData()).willReturn(new int[] {1,2,3});
		
		
		
		assertThat(business.calculateSumUsingDataService(), is(6));
		
	}	
	
	@Test
	void calculateSumUsingDataService_empty() {
		
//		when(someDataService.retrieveAllData()).thenReturn(new int[] {});
		given(someDataService.retrieveAllData()).willReturn(new int[] {});
		
		business.setSomeDataService(someDataService);
		
		assertThat(business.calculateSumUsingDataService(), is(0));
		
	}
	
	@Test
	void calculateSumUsingDataService_oneValue() {
		
//		when(someDataService.retrieveAllData()).thenReturn(new int[] {1});
		given(someDataService.retrieveAllData()).willReturn(new int[] {1});
		
		business.setSomeDataService(someDataService);
		
		assertThat(business.calculateSumUsingDataService(), is(1));
		
	}
}
