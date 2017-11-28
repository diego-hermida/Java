package sort;

import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sorteable<T> {

	@Override
	public void sort(final List<T> elements) {
		for (int index = 1; index < elements.size(); index++) {
			final T key = elements.get(index);
			int i = index - 1;
			while ((i >= 0) && (key.compareTo(elements.get(i)) < 0)) {
				elements.set(i + 1, elements.get(i));
				i--;
			}
			elements.set(i + 1, key);
		}
	}
}
