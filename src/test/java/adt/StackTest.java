package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Test;

import adt.stacks.Stack;

public class StackTest {

	public static final int RESIZE = 70000000;
	public static final int SIZE = 5;

	final Stack stack = new Stack(SIZE);

	@Test
	public void testEmptyStack() {

		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
	}

	@Test(expected = EmptyStackException.class)
	public void testPopEmptyStackException() {
		assertTrue(stack.isEmpty());
		stack.pop();
	}

	@Test(expected = EmptyStackException.class)
	public void testPeekEmptyStackException() {
		assertTrue(stack.isEmpty());
		stack.peek();
	}

	@Test
	public void testPushWithResizedStack() {
		for (int i = 0; i < RESIZE; i++)
			stack.push(i);
		assertEquals(stack.pop(), RESIZE - 1);
	}

	@Test
	public void testPopWithResizedStack() {
		stack.push(1);
		stack.push(2);
		assertEquals(stack.getSize(), 5);
		assertEquals(stack.pop(), 2);
		assertEquals(stack.pop(), 1);
		assertEquals(stack.getSize(), 2);
	}

	@Test
	public void testMakeEmpty() {
		for (int i = 0; i < RESIZE; i++)
			stack.push(i);
		stack.makeEmpty();
		assertTrue(stack.isEmpty());

		/**
		 * If not used makeEmpty, this for loop would cause a
		 * java.lang.OutOfMemoryError.
		 */
		for (int i = 0; i < RESIZE; i++)
			stack.push(i);
		assertFalse(stack.isEmpty());
	}

	/**
	 * Stack "tested" with main in the class
	 */
	@Test
	public void testMainStack() {

		stack.push(5);
		stack.push(8);
		stack.push(2);
		stack.push(9);
		stack.push(5);

		assertFalse(stack.isEmpty());
		assertTrue(stack.isFull());
		assertEquals(stack.peek(), 5);
		assertEquals(stack.pop(), 5);
		assertEquals(stack.peek(), 9);
	}

}
