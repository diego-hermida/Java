package sort;

import java.util.Arrays;
import java.util.List;

public class RadixSort<T> implements Sorteable<Integer> {

	private int getMax(final int[] elements, final int maxIndex) {
		int max = elements[0];
		for (int i = 1; i < maxIndex; i++)
			max = (elements[i] > max) ? elements[i] : max;
		return max;
	}

	private void countSort(final int elements[], final int n, final int exp) {
		final int output[] = new int[n];
		final int count[] = new int[10];
		Arrays.fill(count, 0);

		for (int i = 0; i < n; i++)
			count[(elements[i] / exp) % 10]++;
		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];
		for (int i = n - 1; i >= 0; i--) {
			output[count[(elements[i] / exp) % 10] - 1] = elements[i];
			count[(elements[i] / exp) % 10]--;
		}
		for (int i = 0; i < n; i++)
			elements[i] = output[i];
	}

	private void sort(final int[] elements, final int n) {
		for (int exp = 1; (getMax(elements, n) / exp) > 0; exp *= 10)
			countSort(elements, n, exp);
	}

	@Override
	public void sort(final List<Integer> elements) {
		if (elements.isEmpty())
			return;
		final int[] temp = elements.stream().mapToInt(i -> i).toArray();
		sort(temp, temp.length);
		for (int i = 0; i < temp.length; i++)
			elements.set(i, temp[i]);
	}
}