package com.psl.training.model;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculatorService {

	
	CalculatorService target;
	
	
	public Calculator calc=Mockito.mock(Calculator.class);
	
	@Before
	public void setUp() {
	
	// settting up mock to targeted class
		target =new CalculatorService();
		target.setCal(calc);
		Mockito.when(calc.add(10, 20)).thenReturn(30);
	}
	
	@Test
	public void testValidationCallDone() {
		
			target.performDivision(10, 20);
		Mockito.verify(calc).validateArgument();
		
	}
	
	
	@Test
	public void testPerformCalculation() {
		assertEquals(30, target.performAddition(10, 20));
	}
	
	
	
}
