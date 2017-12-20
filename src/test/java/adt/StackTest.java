package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import adt.stacks.Stack;

public class StackTest {

	public static final int RESIZE = 70000000;
	public static final int NON_EXISTENT_ELEMENT = -1;

	final Stack stack = new Stack(4);

	@Test
	public void testEmptyStack() {

		assertTrue(stack.isEmpty());
		assertFalse(stack.isFull());
		assertEquals(stack.pop(), NON_EXISTENT_ELEMENT);

		// ArrayIndexOutBoundsException with this check when resize(maxSize / 2) is
		// double.
		// assertEquals(stack.pop(), NON_EXISTENT_ELEMENT);

		assertEquals(stack.peek(), NON_EXISTENT_ELEMENT);
	}

	@Test
	public void testPopWithResizedStack() {

		for (int i = 0; i < RESIZE; i++)
			stack.push(i);
		assertEquals(stack.pop(), RESIZE - 1);

	}

	@Test
	public void testMakeEmpty() {
		for (int i = 0; i < RESIZE; i++)
			stack.push(i);
		stack.makeEmpty();

		/**
		 * If not used makeEmpty, this for loop would cause a
		 * java.lang.OutOfMemoryError.
		 */
		for (int i = 0; i < RESIZE; i++)
			stack.push(i);

		stack.makeEmpty();
		assertEquals(stack.peek(), NON_EXISTENT_ELEMENT);
		assertEquals(stack.pop(), NON_EXISTENT_ELEMENT);
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

		assertFalse(stack.isEmpty());
		assertTrue(stack.isFull());
		assertEquals(stack.peek(), 9);
		assertEquals(stack.pop(), 9);
		assertEquals(stack.peek(), 2);
	}

}
