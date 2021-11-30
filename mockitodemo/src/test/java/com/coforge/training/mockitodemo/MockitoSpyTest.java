package com.coforge.training.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockitoSpyTest {

	List<String> list;
	List<String> listSpy;
	
	@BeforeEach
	void setUp() throws Exception {
		list=new ArrayList<String>();
		listSpy=spy(list);
	}

	@Test
	void test() {
		listSpy.add("James Gosling");
		System.out.println(listSpy.get(0));
		
		assertEquals("James Gosling", listSpy.get(0));
		when(listSpy.get(0)).thenReturn("Rod Jhonson");
		
		System.out.println(listSpy.get(0));
		assertEquals("Rod Jhonson",listSpy.get(0));
	}

}
