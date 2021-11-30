package com.coforge.training.mockitodemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class HelloWorld {
	
	@Test
	public void greetTest()
	{
		IDemo d=mock(IDemo.class);  //create mock object for IDemo 
		when(d.greet()).thenReturn(IDemo.S);
		System.out.println("Demo greets :"+d.greet());
		
		assertEquals(d.greet(),IDemo.S);
		

	}

}
