package search;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 */

public class BinarySearch {
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

}
