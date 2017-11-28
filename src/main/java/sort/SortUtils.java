package sort;

import java.util.List;

public final class SortUtils {

	public static <T> void swap(final List<T> elements, final int first,
			final int second) {
		final T temp = elements.get(first);
		elements.set(first, elements.get(second));
		elements.set(second, temp);
	}
}
