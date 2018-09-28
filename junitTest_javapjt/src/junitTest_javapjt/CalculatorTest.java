package junitTest_javapjt;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSum() {
		double result;
		result = Calculator.sum(4,5);
		assertTrue("The result should be 9.",(result == 9));
	}

	@Test
	public void testSubtract() {
		double result;
		result = Calculator.subtract(5,4);
		assertTrue("The result should be 1.",(result == 1));
	}

	@Test
	public void testMultiply() {
		double result;
		result = Calculator.multiply(4,5);
		assertTrue("The result should be 20.",(result == 20));
	}

	@Test
	public void testDivide() {
		double result;
		result = Calculator.divide(15,3);
		assertTrue("The result should be 5.",(result == 5));
	}

	@Test
	public void testCeil() {
		double result;
		result = Calculator.ceil(3.6);
		assertTrue("The result should be 4.",(result == 4));
	}

	@Test
	public void testFloor() {
		double result;
		result = Calculator.floor(3.6);
		assertTrue("The result should be 3.",(result == 3));
	}

	@Test
	public void testAbs() {
		double result;
		result = Calculator.abs(10);
		assertTrue("The result should be 10.",(result == 10));
	}

}
