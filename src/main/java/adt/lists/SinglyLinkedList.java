package adt.lists;

import others.MyNode;

/**
 * This class implements a SinglyLinked List. This is done using
 * SinglyLinkedList class and a LinkForLinkedList Class.
 *
 * A linked list is similar to an array, it hold values. However, links in a
 * linked list do not have indexes. With a linked list you do not need to
 * predetermine it's size as it grows and shrinks as it is edited. This is an
 * example of a singly linked list. Elements can only be added/removed at the
 * head/front of the list.
 *
 * @author Unknown
 *
 */
public class SinglyLinkedList<T> {
	/** Head referred to the front of the list */

	private MyNode<T> head;

	/**
	 * Constructor of SinglyLinkedList
	 */
	public SinglyLinkedList() {
		head = null;
	}

	/**
	 * This method inserts an element at the head
	 *
	 * @param x
	 *            Element to be added
	 */
	public void insertHead(final T x) {
		final MyNode<T> newNode = new MyNode<>(x);
		newNode.setNext(head);
		head = newNode;
	}

	/**
	 * Inserts a new node at a specified position
	 *
	 * @param head
	 *            head node of the linked list
	 * @param data
	 *            data to be stored in a new node
	 * @param position
	 *            position at which a new node is to be inserted
	 * @return reference of the head of the linked list
	 */

	public MyNode<T> InsertAt(final T item, int position) {

		final MyNode<T> newNode = new MyNode<>(item);
		if (position == 0) {
			newNode.setNext(head);
			// The new value of head was not assigned in the previous version
			head = newNode;
			return newNode;
		}
		MyNode<T> current = head;

		while (--position > 0)
			current = current.getNext();

		newNode.setNext(current.getNext());
		current.setNext(newNode);
		return head;
	}

	/**
	 * This method deletes an element at the head
	 *
	 * @return The element deleted
	 */
	public MyNode<T> pop() {
		final MyNode<T> temp = head;
		head = head.getNext();
		return temp;
	}

	/**
	 * Checks if the list is empty
	 *
	 * @return true is list is empty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		MyNode<T> temp = head;
		String value = "";
		while (temp != null) {
			value += temp.getItem().toString() + " ";
			temp = temp.getNext();
		}
		return value;
	}
}
