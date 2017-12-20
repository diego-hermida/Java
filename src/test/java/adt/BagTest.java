package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import adt.bags.Bag;

public class BagTest {

	final Bag<Integer> bag = new Bag<>();

	/**
	 * Bag "tested" with main in the class
	 */
	@Test
	public void testMainBag() {

		// Check if is empty
		assertTrue(bag.isEmpty());

		// Add elements to bag and check size
		bag.add(1);
		bag.add(1);
		bag.add(2);
		assertEquals(bag.size(), 3);
		assertFalse(bag.isEmpty());

		// Check contains
		assertFalse(bag.contains(null));
		assertTrue(bag.contains(1));
		assertFalse(bag.contains(3));

		// Check iterator
		final Iterator<Integer> iterator = bag.iterator();

		iterator.next();
		assertTrue(iterator.hasNext());
		iterator.next();
		assertTrue(iterator.hasNext());
		iterator.next();
		assertFalse(iterator.hasNext());
	}

	@Test(expected = NoSuchElementException.class)
	public void testBagNoSuchElementException() {
		final Iterator<Integer> iterator = bag.iterator();
		iterator.next();
	}

}
