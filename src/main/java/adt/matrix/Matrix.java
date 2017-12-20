package adt.matrix;

import java.util.Arrays;

/**
 * Matrix data-type.
 *
 * @author Kyler Smith, 2017
 */

public class Matrix {

	/**
	 * Data needs to be a deep copy as not to change the original state.
	 */
	private int[][] data;

	/**
	 * Constructor for the matrix takes in a 2D array
	 *
	 * @param pData
	 */
	public Matrix(final int[][] pData) {

		/** Make a deep copy of the data */
		if (pData.length != 0) {
			final int[][] newData = new int[pData.length][pData[0].length];

			for (int i = 0; i < pData.length; i++)
				for (int j = 0; j < pData[0].length; j++)
					newData[i][j] = pData[i][j];

			data = newData;
		} else
			data = null;
	}

	/**
	 * Returns the element specified by the given location
	 *
	 * @param x
	 *            : x cooridinate
	 * @param y
	 *            : y cooridinate
	 * @return int : value at location
	 */
	public int getElement(final int x, final int y) {
		return data[x][y];
	}

	/**
	 * Returns the number of rows in the Matrix
	 *
	 * @return rows
	 */
	public int getRows() {
		if (data == null)
			return 0;

		return data.length;
	}

	/**
	 * Returns the number of rows in the Matrix
	 *
	 * @return columns
	 */
	public int getColumns() {
		if (data == null)
			return 0;
		return data[0].length;
	}

	/**
	 * Returns this matrix scaled by a factor. That is, computes sA where s is a
	 * constant and A is a matrix (this object).
	 *
	 * @param scalar
	 *            : value to scale by
	 * @return A new matrix scaled by the scalar value
	 */
	public Matrix scale(final int scalar) {

		final int[][] newData = new int[data.length][data[0].length];

		for (int i = 0; i < getRows(); ++i)
			for (int j = 0; j < getColumns(); ++j)
				newData[i][j] = data[i][j] * scalar;

		return new Matrix(newData);
	}

	/**
	 * Adds this matrix to another matrix.
	 *
	 * @param other
	 *            : Matrix to be added
	 * @return addend
	 */
	public Matrix plus(final Matrix other) throws RuntimeException {

		final int[][] newData = new int[data.length][data[0].length];

		if ((getRows() != other.getRows()) || (getColumns() != other.getColumns()))
			throw new RuntimeException("Not the same size matrix.");

		for (int i = 0; i < getRows(); ++i)
			for (int j = 0; j < getColumns(); ++j)
				newData[i][j] = data[i][j] + other.getElement(i, j);

		return new Matrix(newData);
	}

	/**
	 * Subtracts this matrix from another matrix.
	 *
	 * @param other
	 *            : Matrix to be subtracted
	 * @return difference
	 */
	public Matrix minus(final Matrix other) throws RuntimeException {

		final int[][] newData = new int[data.length][data[0].length];

		if ((getRows() != other.getRows()) || (getColumns() != other.getColumns()))
			throw new RuntimeException("Not the same size matrix.");

		for (int i = 0; i < getRows(); ++i)
			for (int j = 0; j < getColumns(); ++j)
				newData[i][j] = data[i][j] - other.getElement(i, j);

		return new Matrix(newData);
	}

	/**
	 * Checks if the matrix passed is equal to this matrix
	 *
	 * @param other
	 *            : the other matrix
	 * @return boolean
	 */

	/**
	 * This definition of equals does not compare the fields of the matrix
	 *
	 * public boolean equals(final Matrix other) { return this == other; }
	 *
	 * We need to override the equals like this.
	 */

	public boolean equals(final Matrix other) {
		if (!(other instanceof Matrix))
			return false;
		return Arrays.deepEquals(data, other.data);
	}

	/**
	 * Returns the Matrix as a String in the following format
	 *
	 * [ a b c ] ... [ x y z ] ... [ i j k ] ... ...
	 *
	 */
	@Override
	public String toString() {
		String str = "";

		for (final int[] element : data) {
			str += "[ ";
			for (int j = 0; j < data[0].length; j++) {
				str += element[j];
				str += " ";
			}
			str += "]";
			str += "\n";
		}

		return str;
	}
}
