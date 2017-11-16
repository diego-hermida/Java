package sort;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 */

class InsertionSort {

	/**
	 * This method implements the Generic Insertion Sort
	 *
	 * @param array
	 *            The array to be sorted
	 * @param last
	 *            The count of total number of elements in array Sorts the array
	 *            in increasing order
	 **/

	public static <T extends Comparable<T>> void IS(final T array[],
			final int last) {
		T key;
		for (int j = 1; j < last; j++) {

			// Picking up the key(Card)
			key = array[j];
			int i = j - 1;
			while ((i >= 0) && (key.compareTo(array[i]) < 0)) {
				array[i + 1] = array[i];
				i--;
			}
			// Placing the key (Card) at its correct position in the sorted
			// subarray
			array[i + 1] = key;
		}
	}

	// Driver Program
	public static void main(final String[] args) {
		// Integer Input
		final int[] arr1 = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		int last = arr1.length;
		final Integer[] array = new Integer[arr1.length];
		for (int i = 0; i < arr1.length; i++)
			array[i] = arr1[i];

		InsertionSort.IS(array, last);

		// Output => 1 4 6 9 12 23 54 78 231
		for (final Integer element : array)
			System.out.print(element + " ");
		System.out.println();

		// String Input
		final String[] array1 = { "c", "a", "e", "b", "d" };
		last = array1.length;

		InsertionSort.IS(array1, last);

		// Output => a b c d e
		for (int i = 0; i < last; i++)
			System.out.print(array1[i] + "\t");
	}
}
