package others;

public class MyNode<T> {

	private T item;
	private MyNode<T> previous;
	private MyNode<T> next;

	public MyNode() {
		this(null, null, null);
	}

	public MyNode(final T item) {
		this(item, null, null);
	}

	public MyNode(final T item, final MyNode<T> previous,
			final MyNode<T> next) {
		this.item = item;
		this.previous = previous;
		this.next = next;
	}

	public T getItem() {
		return item;
	}

	public MyNode<T> getPrevious() {
		return previous;
	}

	public MyNode<T> getNext() {
		return next;
	}

	public void setItem(final T item) {
		this.item = item;
	}

	public void setPrevious(final MyNode<T> previous) {
		this.previous = previous;
	}

	public void setNext(final MyNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "MyNode [item=" + item + ", previous=" + previous + ", next="
				+ next + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((item == null) ? 0 : item.hashCode());
		result = (prime * result) + ((next == null) ? 0 : next.hashCode());
		result = (prime * result)
				+ ((previous == null) ? 0 : previous.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object other) {
		if (other instanceof MyNode<?>)
			if (((MyNode<?>) other).item.equals(this.item)
					&& ((MyNode<?>) other).previous.equals(this.previous)
					&& ((MyNode<?>) other).next.equals(this.next))
				return true;
		return false;
	}
}
