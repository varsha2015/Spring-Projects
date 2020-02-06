package com.psl.training.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;


public class TestCalculator {
  
	Calculator target;
  
	@Rule
	public Timeout timeout=new Timeout(20,TimeUnit.MINUTES);
	
	@Rule
	public ExpectedException expectedException =ExpectedException.none();
	
	
	@Before
	public void setUp() {
	 target=new Calculator();	
	}
	
	@Test
	public void testAdd() {
	  int actual=target.add(10,20);
	  int expected =30;
	  assertEquals(expected, actual);  
	
	}
	@Test
	public void testDivWithAllArgGreaterThanZero() {
		int actual=target.div(20,2);
		int expected =10;
		assertEquals(expected, actual);
	}
	
	@Test(timeout = 200)
	public void testDivWithArgumentZeroThrowsException() {
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("argument can't be zero");
		target.div(20,0);
	}
	
	
	@After
	public void tearDown() {
		target=null;
	}
	
  
}
