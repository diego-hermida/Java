package sort;

import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sorteable<T> {

	@Override
	public void sort(final List<T> elements) {
		for (int i = 0; i < (elements.size() - 1); i++) {
			int min = i;
			for (int j = i + 1; j < elements.size(); j++)
				if (elements.get(j).compareTo(elements.get(min)) < 0)
					min = j;
			if (min != i)
				SortUtils.swap(elements, i, min);
		}
	}
}
