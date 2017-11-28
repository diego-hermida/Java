package sort;

import java.util.List;

public interface Sorteable<T extends Comparable<T>> {

	public void sort(final List<T> elements);
}
