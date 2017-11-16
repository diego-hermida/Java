package search;

import java.util.Scanner;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 */

class BinarySearch {
	/**
	 * This method implements the Generic Binary Search
	 *
	 * @param array
	 *            The array to make the binary search
	 * @param key
	 *            The number you are looking for
	 * @param lb
	 *            The lower bound
	 * @param ub
	 *            The upper bound
	 * @return the location of the key
	 **/

	public static <T extends Comparable<T>> int BS(final T array[], final T key,
			final int lb, final int ub) {
		if (lb > ub)
			return -1;

		final int mid = (ub + lb) >>> 1;
		final int comp = key.compareTo(array[mid]);

		if (comp < 0)
			return (BinarySearch.BS(array, key, lb, mid - 1));

		if (comp > 0)
			return (BinarySearch.BS(array, key, mid + 1, ub));

		return mid;
	}

	// Driver Program
	public static void main(final String[] args) {
		final Scanner input = new Scanner(System.in);

		// For INTEGER Input
		final Integer[] array = new Integer[10];
		final int key = 5;

		for (int i = 0; i < 10; i++)
			array[i] = i + 1;

		final int index = BinarySearch.BS(array, key, 0, 9);

		if (index != -1)
			System.out.println(
					"Number " + key + " found at index number : " + index);
		else
			System.out.println("Not found");

		// For STRING Input
		final String[] array1 = { "a", "b", "c", "d", "e" };
		final String key1 = "d";

		final int index1 = BinarySearch.BS(array1, key1, 0, array1.length - 1);

		if (index1 != -1)
			System.out.println(
					"String " + key1 + " found at index number : " + index1);
		else
			System.out.println("Not found");

		input.close();
	}
}
