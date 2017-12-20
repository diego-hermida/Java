package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import adt.stacks.StackOfLinkedList;

public class StackOfLinkedListTest {

	public static final int SIZE = 7000000;

	final StackOfLinkedList stack = new StackOfLinkedList();

	@Test
	public void testEmptyStackOfLinkedList() {

		assertTrue(stack.isEmpty());
		assertEquals(stack.getSize(), 0);

		// NullPointerException with this check.
		// stack.pop();
	}

	@Test
	public void testStackOfLinkedListWithOneElement() {
		assertTrue(stack.isEmpty());
		stack.push(1);
		assertFalse(stack.isEmpty());
		assertEquals(stack.getSize(), 1);
		stack.pop();
	}

	@Test
	public void testBigStackOfLinkedList() {
		for (int i = 0; i < SIZE; i++)
			stack.push(i);
		stack.pop();
		assertEquals(stack.getSize(), SIZE - 1);
	}

	/**
	 * StackOfLinkedList "tested" with main in the class
	 */
	@Test
	public void testMainStackOfLinkedList() {

		stack.push(5);
		stack.push(8);
		stack.push(2);
		stack.push(9);

		assertEquals(stack.getSize(), 4);

		stack.printStack();

		System.out.println("Size of stack currently is: " + stack.getSize());

		stack.pop();
		stack.pop();

		assertEquals(stack.getSize(), 2);
	}

}
