package com.coforge.training.mockitodemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

/*@Mock is used for mock creation. It makes the test class more readable.

@Spy is used to create a spy instance. We can use it instead spy(Object) method.

@InjectMocks is used to instantiate the tested object automatically and inject all the @Mock or @Spy annotated field dependencies into it (if applicable).

@Captor is used to create an argument captor*/

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/*Mockito needs to be initialized, to mock and inject objects marked by Annotations.
​*Annotate the test with the @RunWith(MockitoJUnitRunner.class) so that mockito can process the annotations.*/

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {

	/* Annotate service field with the @InjectMocks annotation to first instantiate and then inject both mocked dependencies.
	 * */
	@InjectMocks
	RecordService recordService;
	
	//create Mock objects of dependency classes to RecordService class
	@Mock
	DatabaseDAO databaseMock;
	
	@Mock
	NetworkDAO networkMock;
	
	@Test
	public void SaveTest()
	{
		boolean saved=recordService.save("hello.txt");
		assertEquals(true,saved);
		
		//verify that methods in the mock objects have been invoked
		verify(databaseMock,times(1)).save("hello.txt");
		verify(networkMock,times(1)).save("hello.txt");
	}
}
