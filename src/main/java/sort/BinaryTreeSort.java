package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeSort<T extends Comparable<T>> implements Sorteable<T> {

    private List<T> tree;

    private Node<T> insert(Node<T> node, final T x) {
        if (node == null)
            return node = new Node<>(x);
        if (x.compareTo(node.getItem()) < 0)
            node.setPrevious(insert(node.getPrevious(), x));
        else
            node.setNext(insert(node.getNext(), x));
        return node;
    }

    private void treeSort(final Node<T> node) {
        if (node != null) {
            treeSort(node.getPrevious());
            tree.add(node.getItem());
            treeSort(node.getNext());
        }
    }

    @Override
    public void sort(final List<T> elements) {
        if (elements.isEmpty())
            return;
        tree = new ArrayList<>(elements.size());
        final Node<T> root = new Node<>(elements.get(0));
        for (int i = 1; i < elements.size(); i++)
            insert(root, elements.get(i));
        treeSort(root);
        Collections.copy(elements, tree);
    }
}
