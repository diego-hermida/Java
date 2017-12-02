package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements Sorteable<T> {

    public void sort(final List<T> arr, final List<T> temp, final int left,
            final int right) {
        if (left < right) {
            final int mid = left + ((right - left) / 2);
            sort(arr, temp, left, mid);
            sort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    public void merge(final List<T> elements, final List<T> temp,
            final int left, final int mid, final int right) {

        for (int index = left; index <= right; index++)
            temp.set(index, elements.get(index));
        int i = left;
        int j = mid + 1;
        int k = left;
        while ((i <= mid) && (j <= right)) {
            if (temp.get(i).compareTo(temp.get(j)) <= 0) {
                elements.set(k, temp.get(i));
                i++;
            } else {
                elements.set(k, temp.get(j));
                j++;
            }
            k++;
        }
        while (i <= mid) {
            elements.set(k, temp.get(i));
            i++;
            k++;
        }
    }

    @Override
    public void sort(final List<T> elements) {
        final List<T> temp = new ArrayList<>(elements);
        sort(elements, temp, 0, elements.size() - 1);
    }
}
