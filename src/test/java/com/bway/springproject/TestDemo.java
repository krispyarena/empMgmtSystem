package com.bway.springproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.testing.Calculation;

public class TestDemo {
	
	static Calculation c;
	
	@BeforeEach
	public void init() {
		c = new Calculation();
	}

	@Test
	public void testArea() {
		
		int result = c.getArea(10, 20);
		
		assertEquals(200, result, "Method Impl Wrong");
	}
	
	@Test
	public void testSI() {
	
		float si = c.getSI(10000, 1, 10);
		
		assertEquals(1000, si, "Test Failed");
	}
	
	@AfterEach
	public void endMethod() {
		System.out.println("----------- Method completed-------------");
	}
}
