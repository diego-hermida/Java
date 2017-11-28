package sort;

import java.util.List;

public class CocktailShakerSort<T extends Comparable<T>>
		implements Sorteable<T> {

	@Override
	public void sort(final List<T> elements) {
		int last = elements.size();
		boolean swap;

		do {
			swap = false;
			for (int index = 0; index <= (last - 2); index++)
				if (elements.get(index)
						.compareTo(elements.get(index + 1)) > 0) {
					SortUtils.swap(elements, index, index + 1);
					swap = true;
				}
			if (!swap)
				break;

			swap = false;
			for (int index = last - 2; index >= 0; index--)
				if (elements.get(index)
						.compareTo(elements.get(index + 1)) > 0) {
					SortUtils.swap(elements, index, index + 1);
					swap = true;
				}
			last--;
		} while (swap);
	}
}
