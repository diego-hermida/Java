package adt.trees;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	private T item;
	private Node<T> previous;
	private Node<T> next;
	private Node<T> parent;

	public Node() {
		this(null, null, null, null);
	}

	public Node(final T item) {
		this(item, null, null, null);
	}

	public Node(final T item, final Node<T> previous, final Node<T> next, final Node<T> parent) {
		this.item = item;
		this.previous = previous;
		this.next = next;
		this.parent = parent;
	}

	public T getItem() {
		return item;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setItem(final T item) {
		this.item = item;
	}

	public void setPrevious(final Node<T> previous) {
		this.previous = previous;
	}

	public void setNext(final Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "MyNode [item=" + item + ", previous=" + previous + ", next=" + next + ", parent=" + parent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((item == null) ? 0 : item.hashCode());
		result = (prime * result) + ((next == null) ? 0 : next.hashCode());
		result = (prime * result) + ((previous == null) ? 0 : previous.hashCode());
		result = (prime * result) + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other instanceof Node<?>)
			if (((Node<?>) other).item.equals(this.item) && ((Node<?>) other).previous.equals(this.previous)
					&& ((Node<?>) other).next.equals(this.next) && ((Node<?>) other).parent.equals(this.parent))
				return true;
		return false;
	}

	@Override
	public int compareTo(final Node<T> node) {
		return item.compareTo(node.item);
	}
}
