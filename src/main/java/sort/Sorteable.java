package sort;

import java.util.List;

public interface Sorteable<T extends Comparable<T>> {

    /**
     * Performs a sort operation on a generic list.
     *
     * @param elements
     *            A <code>java.util.List</code>, which might be empty.
     *
     * @postcondition The list passed by parameter (i.e. <code>elements</code>)
     *                is sorted.
     */
    public void sort(final List<T> elements);
}
