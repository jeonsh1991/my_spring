package junitTest_javapjt;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class Junit4Exam {
	
	@Test(expected = NumberFormatException.class)
	public void testException() throws Exception {
		String str = "hello";
		System.out.println(Integer.parseInt(str));
	}
	
	@Test(timeout = 10000)
	public void testTimeout() throws Exception {
		long sum = 0;
		for(int i =0; i < 100000; i++) {
			for(int j =0; j<100000; j++) {
				sum += j;
			}
		}
		System.out.println(sum);
	}
	
	@Ignore
	@Test
	public void testIgnore() throws Exception {
		assertTrue(false);
		}
	
	@Test
	public void testAssertArrayEquals() throws Exception {
		Object[] a = {"Java", "Python", 1};
		Object[] b = {"Java", "Python", 1};
		assertArrayEquals(a,b);
		}
}
