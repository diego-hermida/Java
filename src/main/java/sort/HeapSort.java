package sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSort<T extends Comparable<T>> implements Sorteable<T> {

    private List<T> heap;
    private int size;

    private void heapSubtree(final int rootIndex, final int lastChild) {
        final int leftIndex = (rootIndex * 2) + 1;
        final int rightIndex = (rootIndex * 2) + 2;
        final T root = heap.get(rootIndex);
        if (rightIndex <= lastChild) {
            final T left = heap.get(leftIndex);
            final T right = heap.get(rightIndex);
            if ((left.compareTo(right) < 0) && (left.compareTo(root) < 0)) {
                SortUtils.swap(heap, leftIndex, rootIndex);
                heapSubtree(leftIndex, lastChild);
            } else if (right.compareTo(root) < 0) {
                SortUtils.swap(heap, rightIndex, rootIndex);
                heapSubtree(rightIndex, lastChild);
            }
        } else if (leftIndex <= lastChild) {
            final T left = heap.get(leftIndex);
            if (left.compareTo(root) < 0) {
                SortUtils.swap(heap, leftIndex, rootIndex);
                heapSubtree(leftIndex, lastChild);
            }
        }
    }

    private void makeMinHeap(final int root) {
        final int leftIndex = (root * 2) + 1;
        final int rightIndex = (root * 2) + 2;
        final boolean hasLeftChild = leftIndex < heap.size();
        final boolean hasRightChild = rightIndex < heap.size();
        if (hasRightChild) {
            makeMinHeap(leftIndex);
            makeMinHeap(rightIndex);
            heapSubtree(root, heap.size() - 1);
        } else if (hasLeftChild)
            heapSubtree(root, heap.size() - 1);
    }

    private T getRoot() {
        SortUtils.swap(heap, 0, size - 1);
        size--;
        heapSubtree(0, size - 1);
        return heap.get(size);
    }

    @Override
    public void sort(final List<T> elements) {
        heap = new ArrayList<>(elements);
        size = elements.size();
        makeMinHeap(0);
        int index = 0;
        while (size > 0) {
            elements.set(index, getRoot());
            index++;
        }
    }
}
