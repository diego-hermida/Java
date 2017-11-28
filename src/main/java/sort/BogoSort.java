package sort;

import java.util.List;
import java.util.Random;

public class BogoSort<T extends Comparable<T>> implements Sorteable<T> {

	private final Random random = new Random();

	private boolean sorted(final List<T> elements) {
		for (int i = 0; i < (elements.size() - 1); i++)
			if (elements.get(i).compareTo(elements.get(i + 1)) > 0)
				return false;
		return true;
	}

	private void nextPermutation(final List<T> elements) {
		for (int i = 0; i < elements.size(); i++)
			SortUtils.swap(elements, i + random.nextInt(elements.size() - i),
					i);
	}

	@Override
	public void sort(final List<T> elements) {
		while (!sorted(elements))
			nextPermutation(elements);
	}
}
