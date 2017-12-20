package adt;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import adt.queues.GenericArrayListQueue;
import sort.util.ExamResult;

public class GenericArrayListQueueTest {

	private static final int SIZE = 1000000;

	final GenericArrayListQueue<Integer> integerQueue = new GenericArrayListQueue<>();
	final GenericArrayListQueue<Double> doubleQueue = new GenericArrayListQueue<>();
	final GenericArrayListQueue<String> stringQueue = new GenericArrayListQueue<>();
	final GenericArrayListQueue<ExamResult> objectQueue = new GenericArrayListQueue<>();

	/**
	 * Random generator. Single instance for all tests.
	 */
	private final Random random = new Random();

	@Test
	public void testNewGenericArrayListQueueIsEmpty() {
		assertEquals(integerQueue.peek(), null);
		assertEquals(integerQueue.poll(), null);
	}

	@Test
	public void testInsertsToEmptyGenericArrayListQueue() {
		final int numberOfInserts = SIZE;
		for (int i = 0; i < numberOfInserts; i++)
			integerQueue.add(i);
	}

	@Test
	public void testEnGenericArrayListqueueThenDeGenericArrayListqueue() {
		integerQueue.add(1);
		assertEquals(integerQueue.poll(), Integer.valueOf(1));
		assertEquals(integerQueue.peek(), null);
	}

	@Test
	public void testEnGenericArrayListqueueThenPeek() {
		integerQueue.add(2);
		assertEquals(integerQueue.peek(), Integer.valueOf(2));
	}

	@Test
	public void testRemovingDownToEmptyGenericArrayListQueue() {
		final int numberOfRemoves = (int) ((Math.random() * 20) + 1);
		for (int i = 0; i < numberOfRemoves; i++)
			integerQueue.add(random.nextInt(Integer.MAX_VALUE));
		for (int i = 0; i < numberOfRemoves; i++)
			assertEquals(integerQueue.peek(), integerQueue.poll());
		assertEquals(integerQueue.peek(), null);
	}

	/**
	 * GenericArrayListQueue "tested" with main in the class
	 */
	@Test
	public void testMainGenericArrayListQueue() {

		assertEquals(integerQueue.peek(), null);
		assertEquals(integerQueue.poll(), null);
		assertEquals(integerQueue.add(1), true);
		assertEquals(integerQueue.peek(), Integer.valueOf(1));
		assertEquals(integerQueue.add(2), true);
		assertEquals(integerQueue.peek(), Integer.valueOf(1));
		assertEquals(integerQueue.poll(), Integer.valueOf(1));
		assertEquals(integerQueue.peek(), Integer.valueOf(2));
		assertEquals(integerQueue.poll(), Integer.valueOf(2));
		assertEquals(integerQueue.peek(), null);
		assertEquals(integerQueue.poll(), null);
	}
}
