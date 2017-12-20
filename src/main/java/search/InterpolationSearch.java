package search;

public class InterpolationSearch {


	// If x is present in arr[0..n-1], then returns
	// index of it, else returns -1.
	static int interpolationSearch(int x, int[] array) {
		// Find indexes of two corners
		int lo = 0, hi = (array.length - 1);

		// Since arrayay is sorted, an element present
		// in arrayay must be in range defined by corner
		while ((lo <= hi) && (x >= array[lo]) && (x <= array[hi])) {
			// Probing the position with keeping
			// uniform distribution in mind.
			int pos = lo + (((hi - lo) / (array[hi] - array[lo])) * (x - array[lo]));

			// Condition of target found
			if (array[pos] == x)
				return pos;

			// If x is larger, x is in upper part
			if (array[pos] < x)
				lo = pos + 1;

			// If x is smaller, x is in lower part
			else
				hi = pos - 1;
		}
		return -1;
	}
}
