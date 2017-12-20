package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Test;

import adt.stacks.StackWithoutSize;

public class StackWithoutSizeTest {

	public static final int SIZE = 7000000;
	public static final int NON_EXISTENT_ELEMENT = -1;

	final StackWithoutSize stack = new StackWithoutSize();

	@Test
	public void testEmptyStackWithoutSize() {
		assertTrue(stack.isEmpty());
	}

	@Test(expected = EmptyStackException.class)
	public void testPopEmptyStackWithoutSizeException() {
		assertTrue(stack.isEmpty());
		stack.pop();
	}

	@Test(expected = EmptyStackException.class)
	public void testPeekEmptyStackWithoutSizeException() {
		assertTrue(stack.isEmpty());
		stack.peek();
	}

	@Test
	public void testBigSizeStackWithoutSize() {
		for (int i = 0; i < SIZE; i++)
			stack.push(i);
		assertEquals(stack.pop(), SIZE - 1);
	}

	/**
	 * StackWithoutSize "tested" with main in the class
	 */
	@Test
	public void testMainStackWithoutSize() {

		stack.push(5);
		stack.push(8);
		stack.push(2);
		stack.push(9);

		assertFalse(stack.isEmpty());
		assertEquals(stack.peek(), 9);
		assertEquals(stack.pop(), 9);
		assertEquals(stack.peek(), 2);
		assertEquals(stack.pop(), 2);
	}

}
