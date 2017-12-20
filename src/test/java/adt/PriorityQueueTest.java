package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import adt.queues.PriorityQueue;

public class PriorityQueueTest {

	private static final int CAPACITY = 300000000;

	final PriorityQueue pqueue = new PriorityQueue(CAPACITY);

	/**
	 * Random generator. Single instance for all tests.
	 */
	private final Random random = new Random();

	@Test
	public void testNewPriorityQueueIsEmpty() {
		assertTrue(pqueue.isEmpty());
		assertEquals(pqueue.getSize(), 0);

		// ArrayIndexOutBoundsException with this check.
		// assertEquals(pqueue.peek(), 0);
	}

	@Test
	public void testInsertsToEmptyPriorityQueue() {
		final int numberOfInserts = 500;
		for (int i = 0; i < numberOfInserts; i++)
			pqueue.insert(random.nextInt(Integer.MAX_VALUE));
		assertFalse(pqueue.isFull());
		assertEquals(pqueue.getSize(), numberOfInserts);
	}

	@Test
	public void testEnPriorityqueueThenDePriorityqueue() {
		pqueue.insert(1);
		assertEquals(pqueue.remove(), 1);
	}

	@Test
	public void testEnPriorityqueueThenPeek() {
		pqueue.insert(2);
		final int size = pqueue.getSize();
		assertEquals(pqueue.peek(), 2);
		assertEquals(pqueue.getSize(), size);
	}

	@Test
	public void testFullcapacityInThenFullcapacityOutPriorityQueue() {
		for (int i = 0; i < CAPACITY; i++)
			pqueue.insert(i);

		assertTrue(pqueue.isFull());
		assertEquals(pqueue.peek(), CAPACITY - 1);

		// ArrayIndexOutBoundsException with this insert.
		// pqueue.insert(1);

		for (int i = CAPACITY - 1; i >= 0; i--)
			assertEquals(pqueue.peek(), pqueue.remove());
		assertTrue(pqueue.isEmpty());
	}

	@Test
	public void testRemovingDownToEmptyPriorityQueue() {
		final int numberOfRemoves = (int) ((Math.random() * 20) + 1);
		for (int i = 0; i < numberOfRemoves; i++)
			pqueue.insert(random.nextInt(Integer.MAX_VALUE));
		for (int i = numberOfRemoves - 1; i >= 0; i--)
			assertEquals(pqueue.peek(), pqueue.remove());
		assertTrue(pqueue.isEmpty());
		assertEquals(pqueue.getSize(), 0);
	}

	/**
	 * PriorityQueue "tested" with main in the class
	 */
	@Test
	public void testMainPriorityQueue() {

		assertTrue(pqueue.isEmpty());

		/**
		 * [1, 2, 3, 4] Here higher numbers have higher priority, so they are on the top
		 */
		pqueue.insert(4);
		assertFalse(pqueue.isEmpty());
		pqueue.insert(1);
		pqueue.insert(3);
		assertFalse(pqueue.isFull());
		pqueue.insert(2);
		assertEquals(pqueue.getSize(), 4);

		/**
		 * Will test the queue in reverse order [4, 3, 2, 1]
		 */
		for (int i = 4; i > 0; i--) {
			assertEquals(pqueue.peek(), i);
			pqueue.remove();
		}
		assertTrue(pqueue.isEmpty());

	}

}
