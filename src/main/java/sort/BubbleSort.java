package sort;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sorteable<T> {

    @Override
    public void sort(final List<T> elements) {
        int last = elements.size();
        boolean swap;

        do {
            swap = false;
            for (int index = 0; index < (last - 1); index++)
                if (elements.get(index)
                        .compareTo(elements.get(index + 1)) > 0) {
                    SortUtils.swap(elements, index, index + 1);
                    swap = true;
                }
            last--;
        } while (swap);
    }
}
