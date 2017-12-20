package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import adt.lists.SinglyLinkedList;

public class SinglyLinkedListTest {

	private static final int SIZE = 70000;

	final SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

	@Test
	public void testEmptySinglyLinkedList() {
		assertTrue(list.isEmpty());

		// NullPointerException with this check.
		// list.pop();

		list.InsertAt(1, 0);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testInsertAt() {
		for (int i = 0; i < SIZE; i++)
			list.InsertAt(1, i);
		assertEquals(list.InsertAt(1, 0).getItem(), list.pop().getItem());
		assertEquals(list.InsertAt(1, 0).getPrevious(), null);
		assertEquals(list.pop().getPrevious(), null);

		// NullPointerException with this check.
		// list.InsertAt(1, x); with 'x' greater than list size.
	}

	/**
	 * SinglyLinkedList "tested" with main in the class
	 */
	@Test
	public void testMainSinglyLinkedList() {

		list.insertHead(5);
		list.insertHead(7);
		list.insertHead(10);

		assertFalse(list.isEmpty());

		System.out.println(list.toString());
		list.pop();
		System.out.println(list.toString());

	}
}
