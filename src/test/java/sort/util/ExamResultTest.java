package sort.util;

import org.junit.Assert;
import org.junit.Test;

public class ExamResultTest {

	@Test
	public void equalityTest() {
		final ExamResult r1 = new ExamResult(5.0, "John Doe", false);
		final ExamResult r2 = new ExamResult(5.0, "John Doe", false);
		final ExamResult r3 = new ExamResult(5.0, "JohnDoe", false);
		final ExamResult r4 = new ExamResult(5.1, "JohnDoe", false);
		final ExamResult r5 = new ExamResult(5.0, "JohnDoe", true);

		Assert.assertEquals(r1, r2);
		Assert.assertNotEquals(r1, r3);
		Assert.assertNotEquals(r1, r4);
		Assert.assertNotEquals(r1, r5);
		Assert.assertNotEquals(r2, r3);
		Assert.assertNotEquals(r3, r4);
		Assert.assertNotEquals(r4, r5);
	}

	@Test
	public void commutationTest() {
		final ExamResult r1 = new ExamResult(5.1, "Abraham Pigeon", false);
		final ExamResult r2 = new ExamResult(5.1, "John Doe", false);
		final int comparison1 = r1.compareTo(r2);
		final int comparison2 = r2.compareTo(r1);
		final int comparison3 = r1.compareTo(r1);
		final int comparison4 = r2.compareTo(r2);

		Assert.assertTrue(comparison1 < 0);
		Assert.assertTrue(comparison2 > 0);
		Assert.assertTrue(comparison3 == 0);
		Assert.assertTrue(comparison4 == 0);
	}

	@Test
	public void transitivityTest() {
		final ExamResult r1 = new ExamResult(5.0, "Abraham Pigeon", false);
		final ExamResult r2 = new ExamResult(5.0, "John Doe", false);
		final ExamResult r3 = new ExamResult(5.0, "Nigel Nigel", false);
		final int comparison1 = r1.compareTo(r2); // 1
		final int comparison2 = r2.compareTo(r3); // 1
		final int comparison3 = r1.compareTo(r3); // 1

		Assert.assertTrue(comparison1 < 0);
		Assert.assertTrue(comparison2 < 0);
		Assert.assertTrue(comparison3 < 0);
	}

	@Test
	public void consistencyTest() {
		final ExamResult r1 = new ExamResult(5.0, "John Doe", false);
		final ExamResult r2 = new ExamResult(5.0, "John Doe", false);
		final ExamResult r3 = new ExamResult(5.0, "Nigel Nigel", false);
		final int comparison1 = r1.compareTo(r2);
		final int comparison2 = r1.compareTo(r3);

		Assert.assertTrue(comparison1 == 0);
		Assert.assertEquals(r1, r2);
		Assert.assertFalse(comparison2 == 0);
		Assert.assertNotEquals(r1, r3);
	}

}
