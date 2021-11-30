package com.coforge.training.mockitodemo;



import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



public class MathApplicationTest {



	@InjectMocks //It is used to create & inject the mock object
	MathApplication mathApplication;
	
	@Mock //--Create a mock object
	CalculatorService calcService;
	
	@Before
	public void setUp() throws Exception {
	mathApplication =new MathApplication();
	MockitoAnnotations.initMocks(this);
	}



@Test
public void testAdd() {
	//add the behaviour of calculator service to add two numbers
	when(calcService.add(10.0 , 20.0)).thenReturn(30.00);
	
	//test the add funtionality
	assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
	
	//verify the behaviour
	verify(calcService).add(10.0,20.0);
	System.out.println(verify(calcService).add(10.0,20.0));
}



@Test
public void testSubtract() {
	when(calcService.subtract(30.0, 20.0)).thenReturn(10.0);
	assertEquals(mathApplication.subtract(30.0, 20.0),10.0,0);
	verify(calcService).subtract(30.0,20.0);
	System.out.println(verify(calcService).subtract(30.0, 20.0));
}



@Test
public void testMultiply() {
	when(calcService.multiply(5.0, 5.0)).thenReturn(25.0);
	assertEquals(mathApplication.multiply(5.0, 5.0),25.0,0);
	verify(calcService).multiply(5.0,5.0);
	System.out.println(verify(calcService).multiply(5.0, 5.0));
}



@Test
public void testDivide() {
	when(calcService.divide(30.0, 10.0)).thenReturn(3.0);
	assertEquals(mathApplication.divide(30.0, 10.0),3.0,0);
	verify(calcService).divide(30.0,10.0);
	System.out.println(verify(calcService).divide(30.0, 10.0));
}


}