package com.in28minutes.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		
		String responseFromService = "["
				+ "{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5},"
				+ "{\"id\":10001, \"name\":\"Pen\", \"quantity\":15},"
				+ "{\"id\":10002, \"name\":\"Eraser\", \"quantity\":10},"
				+ "]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
	}
	
}
