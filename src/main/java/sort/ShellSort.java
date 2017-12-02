package sort;

import java.util.List;

public class ShellSort<T extends Comparable<T>> implements Sorteable<T> {

    @Override
    public void sort(final List<T> elements) {
        int h = 1;
        while (h < (elements.size() / 3))
            h = (3 * h) + 1;
        while (h >= 1) {
            for (int i = h; i < elements.size(); i++)
                for (int j = i; (j >= h) && (elements.get(j)
                        .compareTo(elements.get(j - h)) < 0); j -= h)
                    SortUtils.swap(elements, j, j - h);
            h /= 3;
        }
    }
}
