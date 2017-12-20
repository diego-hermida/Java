package adt.bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Collection which does not allow removing elements (only collect and iterate)
 *
 * @param <Element>
 *            - the generic type of an element in this bag
 */
public class Bag<Element> implements Iterable<Element> {

	private Node<Element> firstElement; // first element of the bag
	private int size; // size of bag

	private static class Node<Element> {
		private Element content;
		private Node<Element> nextElement;
	}

	/**
	 * Create an empty bag
	 */
	public Bag() {
		firstElement = null;
		size = 0;
	}

	/**
	 * @return true if this bag is empty, false otherwise
	 */
	public boolean isEmpty() {
		return firstElement == null;
	}

	/**
	 * @return the number of elements
	 */
	public int size() {
		return size;
	}

	/**
	 * @param element
	 *            - the element to add
	 */
	public void add(final Element element) {
		final Node<Element> oldfirst = firstElement;
		firstElement = new Node<>();
		firstElement.content = element;
		firstElement.nextElement = oldfirst;
		size++;
	}

	/**
	 * Checks if the bag contains a specific element
	 *
	 * @param element
	 *            which you want to look for
	 * @return true if bag contains element, otherwise false
	 */
	public boolean contains(final Element element) {
		final Iterator<Element> iterator = this.iterator();
		while (iterator.hasNext())
			if (iterator.next().equals(element))
				return true;
		return false;
	}

	/**
	 * @return an iterator that iterates over the elements in this bag in arbitrary
	 *         order
	 */
	@Override
	public Iterator<Element> iterator() {
		return new ListIterator<>(firstElement);
	}

	@SuppressWarnings("hiding")
	private class ListIterator<Element> implements Iterator<Element> {
		private Node<Element> currentElement;

		public ListIterator(final Node<Element> firstElement) {
			currentElement = firstElement;
		}

		@Override
		public boolean hasNext() {
			return currentElement != null;
		}

		/**
		 * remove is not allowed in a bag
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Element next() {
			if (!hasNext())
				throw new NoSuchElementException();
			final Element element = currentElement.content;
			currentElement = currentElement.nextElement;
			return element;
		}
	}

}
