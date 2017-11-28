package sort;

import java.util.List;

public class CycleSort<T extends Comparable<T>> implements Sorteable<T> {

	@Override
	public void sort(final List<T> elements) {
		for (int cycleStart = 0; cycleStart <= (elements.size()
				- 2); cycleStart++) {
			final T item = elements.get(cycleStart);

			int pos = cycleStart;
			for (int index = cycleStart + 1; index < elements.size(); index++)
				if (elements.get(index).compareTo(item) > 0)
					pos++;
			if (pos == cycleStart)
				continue;
			while (item == elements.get(pos))
				pos++;
			if (pos != cycleStart)
				SortUtils.swap(elements, cycleStart, pos);
			while (pos != cycleStart) {
				pos = cycleStart;
				for (int index = cycleStart + 1; index < elements
						.size(); index++)
					if (elements.get(index).compareTo(item) > 0)
						pos++;
				while (item == elements.get(pos))
					pos++;
				if (item.compareTo(elements.get(pos)) != 0)
					SortUtils.swap(elements, cycleStart, pos);
			}
		}
	}
}
