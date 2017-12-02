package sort;

import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sorteable<T> {

    public void sort(final List<T> elements, final int start, final int end) {
        if (start < end) {
            final int pivot = partition(elements, start, end);
            sort(elements, start, pivot - 1);
            sort(elements, pivot + 1, end);
        }
    }

    public int partition(final List<T> elements, final int start,
            final int end) {
        final T pivotElement = elements.get(end);
        int pivot = start;
        for (int index = start; index < end; index++)
            if (elements.get(index).compareTo(pivotElement) <= 0) {
                SortUtils.swap(elements, index, pivot);
                pivot++;
            }
        SortUtils.swap(elements, pivot, end);
        return pivot;
    }

    @Override
    public void sort(final List<T> elements) {
        sort(elements, 0, elements.size() - 1);
    }
}
