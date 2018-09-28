package junitTest_javapjt;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class junit_ex {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}
	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}
	@Test
	public void testCase4() throws Exception {
		System.out.println("testCase4");
	}
	@Test
	public void testCase2() throws Exception {
		System.out.println("testCase2");
	}

}
