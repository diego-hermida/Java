package sort;

import java.util.Arrays;

class Radix {

	static int getMax(final int arr[], final int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	static void countSort(final int arr[], final int n, final int exp) {
		final int output[] = new int[n];
		int i;
		final int count[] = new int[10];
		Arrays.fill(count, 0);

		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	static void radixsort(final int arr[], final int n) {

		final int m = Radix.getMax(arr, n);

		for (int exp = 1; (m / exp) > 0; exp *= 10)
			Radix.countSort(arr, n, exp);
	}

	static void print(final int arr[], final int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(final String[] args) {
		final int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		final int n = arr.length;
		Radix.radixsort(arr, n);
		Radix.print(arr, n);
	}
}
// Written by James Mc Dermott(theycallmemac)
