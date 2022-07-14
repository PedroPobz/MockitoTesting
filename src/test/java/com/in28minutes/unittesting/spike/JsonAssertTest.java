package com.in28minutes.unittesting.spike;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.*;

class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssertTest_StrictTrue() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}

	@Test
	public void jsonAssertTest_StrictFalse() throws JSONException{

		String expectedResponse = "{\"id\":1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssertTest_NoEscapeCharacters() throws JSONException{

		String expectedResponse = "{id:1, name:Ball, price:10, quantity:100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
}
