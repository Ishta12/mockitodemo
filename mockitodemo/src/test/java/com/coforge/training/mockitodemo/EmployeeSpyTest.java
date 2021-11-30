package com.coforge.training.mockitodemo;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;

/*
    @Spy is used to create a spy instance. We can use it instead spy(Object) method.

    Mockito provides option to create spy on real objects. When spy is called, then actual method of real object is called.

 */
public class EmployeeSpyTest {
	
	private Employee spyEmp;
	private Employee emp;
	
	private static final String FIRST_NAME = "Joe";
	private static final String LAST_NAME = "M";
	private static final int AGE = 35;
	
	@Before
	public void buildSpy() {
		emp = new Employee(FIRST_NAME, LAST_NAME, AGE);
		spyEmp = spy(emp); //created a spy object of Employee using static method spy()
	}
	
	@Test
	public void verifySpyEffectOnRealInstance() {
		spyEmp.setAge(20);
		assertFalse(emp.getAge() == spyEmp.getAge());
	}
}
