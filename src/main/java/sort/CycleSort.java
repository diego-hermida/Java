package sort;

class CycleSort {
	// Function that sort the array using Cycle sort
	public static void cycleSort(final int arr[], final int n) {
		// traverse array elements
		for (int cycle_start = 0; cycle_start <= (n - 2); cycle_start++) {
			// initialize item as starting point
			int item = arr[cycle_start];

			// Find position where we put the item.
			int pos = cycle_start;
			for (int i = cycle_start + 1; i < n; i++)
				if (arr[i] < item)
					pos++;

			// If item is already in correct position
			if (pos == cycle_start)
				continue;

			// ignore all duplicate elements
			while (item == arr[pos])
				pos += 1;

			// put the item to it's right position
			if (pos != cycle_start) {
				final int temp = item;
				item = arr[pos];
				arr[pos] = temp;
			}

			// Rotate rest of the cycle
			while (pos != cycle_start) {
				pos = cycle_start;

				// Find position where we put the element
				for (int i = cycle_start + 1; i < n; i++)
					if (arr[i] < item)
						pos += 1;

				// ignore all duplicate elements
				while (item == arr[pos])
					pos += 1;

				// put the item to it's right position
				if (item != arr[pos]) {
					final int temp = item;
					item = arr[pos];
					arr[pos] = temp;
				}
			}
		}
	}

	// main program to test above function
	public static void main(final String[] args) {
		final int arr[] = { 1, 8, 3, 9, 10, 10, 2, 4 };
		final int n = arr.length;
		CycleSort.cycleSort(arr, n);

		System.out.println("After sort : ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
