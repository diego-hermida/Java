package sort;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Youssef Ali (https://github.com/youssefAli11997)
 *
 */

class CountingSort {

	/**
	 * This method implements the Generic Counting Sort
	 *
	 * @param array
	 *            The array to be sorted
	 * @param last
	 *            The count of total number of elements in array Sorts the array
	 *            in increasing order It uses array elements as keys in the
	 *            frequency map
	 **/

	public static <T extends Comparable<T>> void CS(final T[] array,
			final int last) {

		final Map<T, Integer> frequency = new TreeMap<>();
		// The final output array
		final ArrayList<T> sortedArray = new ArrayList<>();

		// Counting the frequency of @param array elements
		for (final T t : array)
			try {
				frequency.put(t, frequency.get(t) + 1);
			} catch (final Exception e) { // new entry
				frequency.put(t, 1);
			}

		// Filling the sortedArray
		for (final Map.Entry<T, Integer> element : frequency.entrySet())
			for (int j = 0; j < element.getValue(); j++)
				sortedArray.add(element.getKey());

		for (int i = 0; i < array.length; i++)
			array[i] = sortedArray.get(i);
	}

	// Driver Program
	public static void main(final String[] args) {
		// Integer Input
		final Integer[] arr1 = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		int last = arr1.length;

		System.out.println("Before Sorting:");
		for (final Integer element : arr1)
			System.out.print(element + " ");
		System.out.println();

		CountingSort.CS(arr1, last);

		// Output => 1 4 6 9 12 23 54 78 231
		System.out.println("After Sorting:");
		for (final Integer element : arr1)
			System.out.print(element + " ");
		System.out.println();

		System.out.println("------------------------------");

		// String Input
		final String[] array1 = { "c", "a", "e", "b", "d" };
		last = array1.length;

		System.out.println("Before Sorting:");
		for (final String element : array1)
			System.out.print(element + " ");
		System.out.println();

		CountingSort.CS(array1, last);

		// Output => a b c d e
		System.out.println("After Sorting:");
		for (int i = 0; i < last; i++)
			System.out.print(array1[i] + " ");

	}
}
