package adt.bags;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagTest {

	@Test
	void testBag() {

		final Bag<String> bag = new Bag<>();

		bag.add("1");
		bag.add("1");
		bag.add("2");

		Assertions.assertEquals(3, bag.size());
		Assertions.assertFalse(bag.contains(null));
		Assertions.assertTrue(bag.contains("1"));
		Assertions.assertFalse(bag.contains("3"));
	}

}
