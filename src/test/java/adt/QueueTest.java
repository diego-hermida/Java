package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import adt.queues.Queue;

public class QueueTest {

	private static final int CAPACITY = 300000000;

	final Queue queue = new Queue(CAPACITY);

	/**
	 * Random generator. Single instance for all tests.
	 */
	private final Random random = new Random();

	@Test
	public void testNewQueueIsEmpty() {
		assertTrue(queue.isEmpty());
		assertEquals(queue.getSize(), 0);
		assertEquals(queue.peekFront(), 0);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testPeekRearArrayIndexOutBoundsException() {
		queue.peekRear();
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testPeekRemoveArrayIndexOutBoundsException() {
		queue.remove();
	}

	@Test
	public void testInsertsToEmptyQueue() {
		final int numberOfInserts = 500;
		for (int i = 0; i < numberOfInserts; i++)
			queue.insert(random.nextInt(Integer.MAX_VALUE));
		assertFalse(queue.isFull());
		assertEquals(queue.getSize(), numberOfInserts);
	}

	@Test
	public void testEnqueueThenDequeue() {
		queue.insert(1);
		assertEquals(queue.remove(), 1);
	}

	@Test
	public void testEnqueueThenPeek() {
		queue.insert(2);
		final int size = queue.getSize();
		assertEquals(queue.peekFront(), 2);
		assertEquals(queue.getSize(), size);
	}

	@Test
	public void testFullcapacityInThenFullcapacityOutQueue() {
		for (int i = 0; i < CAPACITY; i++)
			queue.insert(i);
		assertTrue(queue.isFull());
		assertEquals(queue.peekRear(), CAPACITY - 1);

		for (int i = 0; i < CAPACITY; i++)
			assertEquals(queue.peekFront(), queue.remove());
		assertTrue(queue.isEmpty());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testArrayIndexOutOfBoundsExceptionWithInsert() {
		for (int i = 0; i < CAPACITY; i++)
			queue.insert(i);
		assertTrue(queue.isFull());
		assertEquals(queue.peekRear(), CAPACITY - 1);
		
		// ArrayIndexOutOfBoundsException with this insert.
		queue.insert(61);
	}

	@Test
	public void testRemovingDownToEmptyQueue() {
		final int numberOfRemoves = (int) ((Math.random() * 20) + 1);
		for (int i = 0; i < numberOfRemoves; i++)
			queue.insert(random.nextInt(Integer.MAX_VALUE));
		for (int i = 0; i < numberOfRemoves; i++)
			assertEquals(queue.peekFront(), queue.remove());
		assertTrue(queue.isEmpty());
		assertEquals(queue.getSize(), 0);
	}

	/**
	 * Queue "tested" with main in the class
	 */
	@Test
	public void testMainQueue() {

		/**
		 * [10(front), 2, 5, 3(rear)]
		 */
		queue.insert(10);
		assertFalse(queue.isEmpty());
		queue.insert(2);
		queue.insert(5);
		queue.insert(3);
		assertEquals(queue.peekFront(), 10);
		assertEquals(queue.peekRear(), 3);
		assertEquals(queue.getSize(), 4);

		/**
		 * Will make 2 the new front, making 10 no longer part of the queue [10,
		 * 2(front), 5, 3(rear)]
		 */
		queue.remove();
		assertEquals(queue.getSize(), 3);

		/**
		 * Insert 7 at the rear which will be index 0 because of wrap around [7(rear),
		 * 2(front), 5, 3]
		 */
		queue.insert(7);
		assertEquals(queue.peekFront(), 2);
		assertEquals(queue.peekRear(), 7);
	}
}
