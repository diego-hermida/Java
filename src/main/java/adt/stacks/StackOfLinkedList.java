package adt.stacks;

import java.util.EmptyStackException;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 *         A class which implements a stack using a linked list
 *
 *         Contains all the stack methods : push, pop, printStack, isEmpty
 **/
public class StackOfLinkedList {

	// A node class
	class Node {
		public int data;
		public Node next;

		public Node(final int data) {
			this.data = data;
			next = null;
		}
	}

	Node head = null;
	private int size = 0;

	public StackOfLinkedList() {
	}

	public void push(final int x) {
		final Node n = new Node(x);
		if (getSize() == 0)
			head = n;
		else {
			final Node temp = head;
			n.next = temp;
			head = n;
		}
		size++;
	}

	public void pop() {
		if (getSize() == 0)
			throw new EmptyStackException();
		head = head.next;
		size--;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public int getSize() {
		return size;
	}
}