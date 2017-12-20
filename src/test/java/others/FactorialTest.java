package others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void factorialTest() {
		assertEquals(1, Factorial.factorial(0));
		assertEquals(1, Factorial.factorial(1));
		assertEquals(2, Factorial.factorial(2));
		assertEquals(3628800, Factorial.factorial(10));
		//assertEquals(1, Factorial.factorial(-1));
	}
}
