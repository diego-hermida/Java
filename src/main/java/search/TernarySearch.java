package search;

public class TernarySearch {

	/**
	 * @param arr
	 *            The **Sorted** array in which we will search the element.
	 * @param value
	 *            The value that we want to search for.
	 * @return The index of the element if found. Else returns -1.
	 */
	public static <T extends Comparable<T>> int ternarySearch(final T[] arr, final T value) {
		return TernarySearch.ternarySearch(arr, value, 0, arr.length - 1);
	}

	/**
	 * @param arr
	 *            The **Sorted** array in which we will search the element.
	 * @param key
	 *            The value that we want to search for.
	 * @param start
	 *            The starting index from which we will start Searching.
	 * @param end
	 *            The ending index till which we will Search.
	 * @return Returns the index of the Element if found. Else returns -1.
	 */
	public static <T extends Comparable<T>> int ternarySearch(final T[] arr, final T key,
			final int start, final int end) {
		if (start > end)
			return -1;
		/* First boundary: add 1/3 of length to start */
		final int mid1 = start + ((end - start) / 3);
		/* Second boundary: add 2/3 of length to start */
		final int mid2 = start + ((2 * (end - start)) / 3);
		if (arr[mid1] == key)
			return mid1;
		else if (arr[mid2] == key)
			return mid2;
		else if (key.compareTo(arr[mid1]) < 0)
			return TernarySearch.ternarySearch(arr, key, start, mid1 - 1);
		else if (key.compareTo(arr[mid1]) > 0)
			return TernarySearch.ternarySearch(arr, key, mid2 + 1, end);
		else
			return TernarySearch.ternarySearch(arr, key, mid1, mid2);
	}
}