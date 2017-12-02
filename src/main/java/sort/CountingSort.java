package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CountingSort<T extends Comparable<T>> implements Sorteable<T> {

    @Override
    public void sort(final List<T> elements) {
        final Map<T, Integer> frequency = new TreeMap<>();
        final ArrayList<T> temp = new ArrayList<>(elements.size());

        for (final T t : elements)
            try {
                frequency.put(t, frequency.get(t) + 1);
            } catch (final Exception e) {
                frequency.put(t, 1);
            }
        for (final Map.Entry<T, Integer> element : frequency.entrySet())
            for (int index = 0; index < element.getValue(); index++)
                temp.add(element.getKey());
        Collections.copy(elements, temp);
    }
}
