package search;

import java.util.Scanner;

public class TernarySearch {

	/**
	 * @param arr
	 *            The **Sorted** array in which we will search the element.
	 * @param value
	 *            The value that we want to search for.
	 * @return The index of the element if found. Else returns -1.
	 */
	public static int ternarySearch(final int[] arr, final int value) {
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
	public static int ternarySearch(final int[] arr, final int key,
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
		else if (key < arr[mid1])
			return TernarySearch.ternarySearch(arr, key, start, mid1 - 1);
		else if (key > arr[mid2])
			return TernarySearch.ternarySearch(arr, key, mid2 + 1, end);
		else
			return TernarySearch.ternarySearch(arr, key, mid1, mid2);
	}

	public static void main(final String[] args) {
		try (final Scanner s = new Scanner(System.in)) {
			System.out.println("Enter number of elements in the array");
			final int n = s.nextInt();
			final int arr[] = new int[n];
			System.out.println("Enter the elements of the Sorted array");
			for (int i = 0; i < n; i++)
				arr[i] = s.nextInt();
			System.out.println("Enter element to search for : ");
			final int k = s.nextInt();
			final int ans = TernarySearch.ternarySearch(arr, k);
			if (ans == -1)
				System.out.println(" The element is not present in the array.");
			else
				System.out.println(
						"The element is present at the position " + (ans + 1));
		} catch (final Exception e) {
			throw e;
		}
	}
}