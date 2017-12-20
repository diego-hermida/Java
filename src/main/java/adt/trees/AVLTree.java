package adt.trees;

public class AVLtree {

	private Node root;

	private class Node {
		private int key;
		private int balance;
		private int height;
		private Node left, right, parent;

		Node(final int k, final Node p) {
			key = k;
			parent = p;
		}
	}

	public boolean insert(final int key) {
		if (root == null)
			root = new Node(key, null);
		else {
			Node n = root;
			Node parent;
			while (true) {
				if (n.key == key)
					return false;

				parent = n;

				final boolean goLeft = n.key > key;
				n = goLeft ? n.left : n.right;

				if (n == null) {
					if (goLeft)
						parent.left = new Node(key, parent);
					else
						parent.right = new Node(key, parent);
					rebalance(parent);
					break;
				}
			}
		}
		return true;
	}

	private void delete(final Node node) {
		if ((node.left == null) && (node.right == null)) {
			if (node.parent == null)
				root = null;
			else {
				final Node parent = node.parent;
				if (parent.left == node)
					parent.left = null;
				else
					parent.right = null;
				rebalance(parent);
			}
			return;
		}
		if (node.left != null) {
			Node child = node.left;
			while (child.right != null)
				child = child.right;
			node.key = child.key;
			delete(child);
		} else {
			Node child = node.right;
			while (child.left != null)
				child = child.left;
			node.key = child.key;
			delete(child);
		}
	}

	public void delete(final int delKey) {
		if (root == null)
			return;
		Node node = root;
		Node child = root;

		while (child != null) {
			node = child;
			child = delKey >= node.key ? node.right : node.left;
			if (delKey == node.key) {
				delete(node);
				return;
			}
		}
	}

	private void rebalance(Node n) {
		setBalance(n);

		if (n.balance == -2) {
			if (height(n.left.left) >= height(n.left.right))
				n = rotateRight(n);
			else
				n = rotateLeftThenRight(n);

		} else if (n.balance == 2)
			if (height(n.right.right) >= height(n.right.left))
				n = rotateLeft(n);
			else
				n = rotateRightThenLeft(n);

		if (n.parent != null)
			rebalance(n.parent);
		else
			root = n;
	}

	private Node rotateLeft(final Node a) {

		final Node b = a.right;
		b.parent = a.parent;

		a.right = b.left;

		if (a.right != null)
			a.right.parent = a;

		b.left = a;
		a.parent = b;

		if (b.parent != null)
			if (b.parent.right == a)
				b.parent.right = b;
			else
				b.parent.left = b;

		setBalance(a, b);

		return b;
	}

	private Node rotateRight(final Node a) {

		final Node b = a.left;
		b.parent = a.parent;

		a.left = b.right;

		if (a.left != null)
			a.left.parent = a;

		b.right = a;
		a.parent = b;

		if (b.parent != null)
			if (b.parent.right == a)
				b.parent.right = b;
			else
				b.parent.left = b;

		setBalance(a, b);

		return b;
	}

	private Node rotateLeftThenRight(final Node n) {
		n.left = rotateLeft(n.left);
		return rotateRight(n);
	}

	private Node rotateRightThenLeft(final Node n) {
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}

	private int height(final Node n) {
		if (n == null)
			return -1;
		return n.height;
	}

	private void setBalance(final Node... nodes) {
		for (final Node n : nodes)
			reheight(n);
		n.balance = height(n.right) - height(n.left);
	}

	public void printBalance() {
		printBalance(root);
	}

	private void printBalance(final Node n) {
		if (n != null) {
			printBalance(n.left);
			System.out.printf("%s ", n.balance);
			printBalance(n.right);
		}
	}

	private void reheight(final Node node) {
		if (node != null)
			node.height = 1 + Math.max(height(node.left), height(node.right));
	}

	public static void main(final String[] args) {
		final AVLtree tree = new AVLtree();

		System.out.println("Inserting values 1 to 10");
		for (int i = 1; i < 10; i++)
			tree.insert(i);

		System.out.print("Printing balance: ");
		tree.printBalance();
	}
}
