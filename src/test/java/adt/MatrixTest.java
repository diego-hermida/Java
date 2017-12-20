package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import adt.matrix.Matrix;

public class MatrixTest {

	/**
	 * Initialize data
	 */
	final int[][] data1 = new int[0][0];
	final int[][] data2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	final int[][] data3 = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };

	final Matrix m1 = new Matrix(data1);
	final Matrix m2 = new Matrix(data2);
	final Matrix m3 = new Matrix(data3);

	@Test
	public void testEmptyMatrix() {

		// This checks produces a NullPointerException.
		//
		// assertEquals(m1.getElement(0, 0), null);
		//
		// assertTrue(m1.scale(2).equals(m1));
		//
		// assertTrue(m1.plus(m2).equals(m2));
		//
		// m1.minus(m2);
		//
		// m1.toString();

		assertEquals(m1.getRows(), 0);
		assertEquals(m1.getColumns(), 0);

	}

	@Test
	public void testGetMatrixElements() {

		assertEquals(m2.getElement(0, 0), 1);
		assertEquals(m3.getElement(2, 2), 9);

		// This checks produces a ArrayIndexOutBoundsException.
		// assertEquals(m2.getElement(-1, -1), null);
		// assertEquals(m3.getElement(3, 3), null);
	}

	@Test
	public void testMatrixOperations() {
		final int[][] testData = new int[3][3];
		final Matrix testM = new Matrix(testData);

		assertTrue(m2.plus(testM).equals(m2));
		assertTrue(m3.minus(testM).equals(m3));
		assertTrue(testM.scale(10).equals(testM));
		assertTrue(m2.plus(testM).minus(m2).equals(testM));
	}

	@Test(expected = RuntimeException.class)
	public void testPlusDifferentRowsSizeMatrices() {
		final int[][] testData = new int[2][3];
		final Matrix testM = new Matrix(testData);

		m2.plus(testM);
	}

	@Test(expected = RuntimeException.class)
	public void testPlusDifferentColumnsSizeMatrices() {
		final int[][] testData = new int[3][2];
		final Matrix testM = new Matrix(testData);

		m2.plus(testM);
	}

	@Test(expected = RuntimeException.class)
	public void testMinusDifferentRowsSizeMatrices() {
		final int[][] testData = new int[2][3];
		final Matrix testM = new Matrix(testData);

		m2.minus(testM);
	}

	@Test(expected = RuntimeException.class)
	public void testMinusDifferentColumnsSizeMatrices() {
		final int[][] testData = new int[3][2];
		final Matrix testM = new Matrix(testData);

		m2.minus(testM);
	}

	/**
	 * Matrix "tested" with main in the class
	 */
	@Test
	public void testMainMatrix() {

		assertEquals(m2.getRows(), 3);
		assertEquals(m2.getColumns(), 3);
		assertEquals(m3.getRows(), 3);
		assertEquals(m3.getColumns(), 3);

		assertFalse(m2.equals(null));
		assertFalse(m2.equals(m1));
		assertTrue(m2.equals(m2));
		assertFalse(m2.equals(m3));

		// System.out.println("m2 -->\n" + m2);
		m2.toString();
		// System.out.println("m3 -->\n" + m3);

		// test operations (valid)
		final int[][] expectedData1 = { { 2, 4, 6 }, { 8, 10, 12 }, { 14, 16, 18 } };
		Matrix expectedM = new Matrix(expectedData1);
		assertTrue(m2.scale(2).equals(expectedM));
		final int[][] expectedData2 = { { 2, 6, 10 }, { 6, 10, 14 }, { 10, 14, 18 } };
		expectedM = new Matrix(expectedData2);
		assertTrue(m3.plus(m2).equals(expectedM));
		final int[][] expectedData3 = { { 0, -2, -4 }, { 2, 0, -2 }, { 4, 2, 0 } };
		expectedM = new Matrix(expectedData3);
		assertTrue(m2.minus(m3).equals(expectedM));

	}

}
