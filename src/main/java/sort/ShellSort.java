package sort;

/**
 * @author dpunosevac
 */
public class ShellSort {

	/**
	 * This method implements Generic Shell Sort.
	 *
	 * @param array
	 *            The array to be sorted
	 */
	public static void shellSort(final Comparable[] array) {
		final int N = array.length;
		int h = 1;

		while (h < (N / 3))
			h = (3 * h) + 1;

		while (h >= 1) {
			for (int i = h; i < N; i++)
				for (int j = i; (j >= h)
						&& ShellSort.less(array[j], array[j - h]); j -= h)
					ShellSort.exch(array, j, j - h);

			h /= 3;
		}
	}

	/**
	 * Helper method for exchanging places in array
	 *
	 * @param array
	 *            The array which elements we want to swap
	 * @param i
	 *            index of the first element
	 * @param j
	 *            index of the second element
	 */
	private static void exch(final Comparable[] array, final int i,
			final int j) {
		final Comparable swap = array[i];
		array[i] = array[j];
		array[j] = swap;
	}

	/**
	 * This method checks if first element is less then the other element
	 *
	 * @param v
	 *            first element
	 * @param w
	 *            second element
	 * @return true if the first element is less then the second element
	 */
	private static boolean less(final Comparable v, final Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(final String[] args) {
		// Integer Input
		final int[] arr1 = { 4, 23, 6, 78, 1, 54, 231, 9, 12 };
		final Integer[] array = new Integer[arr1.length];

		for (int i = 0; i < arr1.length; i++)
			array[i] = arr1[i];

		ShellSort.shellSort(array);

		for (final Integer element : array)
			System.out.println(element);
	}
}
