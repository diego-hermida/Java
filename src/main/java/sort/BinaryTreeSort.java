package sort;

import java.util.Arrays;

import others.Node;

public class BinaryTreeSort {

	public Node root;

	public BinaryTreeSort(final Object x) {
		root = new Node(x);
	}// end TreeSort constructor

	public Node insert(Node node, final Integer x) {
		if (node == null)
			return node = new Node(x);
		if (x < (Integer) node.item)
			node.previous = insert(node.previous, x);
		else
			node.next = insert(node.next, x);
		return node;
	}// end insert

	public Node decimalInsert(Node node, final Double x) {
		if (node == null)
			return node = new Node(x);
		if (x < (Double) node.item)
			node.previous = decimalInsert(node.previous, x);
		else
			node.next = decimalInsert(node.next, x);
		return node;
	}// end insert

	public void treeSort(final Node node) {
		if (node != null) {
			treeSort(node.previous);
			System.out.print((node.item) + ", ");
			treeSort(node.next);
		} // end if
	}// end TreeSort class

	public static void main(final String args[]) {
		final int[] intArray = { 12, 40, 9, 3, 19, 74, 7, 31, 23, 54, 26, 81,
				12 };
		final BinaryTreeSort ts = new BinaryTreeSort(new Integer(intArray[0]));
		for (int i = 1; i < intArray.length; i++)
			// list one at a time
			ts.insert(ts.root, new Integer(intArray[i])); // builds on the tree
															// from a root node
		System.out.print("Integer Array Sorted in Increasing Order: ");
		ts.treeSort(ts.root);
		System.out.println(); // To sort a test array of integers

		final Double[] decimalArray = { 8.2, 1.5, 3.14159265, 9.3, 5.1, 4.8,
				2.6 };
		final BinaryTreeSort dts = new BinaryTreeSort(
				new Double(decimalArray[0]).doubleValue());
		for (int i = 1; i < decimalArray.length; i++)
			// the list one at a
			// time
			dts.decimalInsert(dts.root,
					new Double(decimalArray[i]).doubleValue()); // builds on the
																// tree from a
																// root node
		System.out.print("Decimal Array, Sorted in Increasing Order: ");
		dts.treeSort(dts.root);
		System.out.println();

		final String[] stringArray = { "c", "a", "e", "b", "d", "dd", "da",
				"zz", "AA", "aa", "aB", "Hb", "Z" };
		final int last = stringArray.length;
		Arrays.sort(stringArray); // Uses an imported arrays method to
									// automatically alphabetize
		System.out.print("String Array Sorted in Alphabetical Order: ");
		ts.insert(ts.root, last);
		for (int i = 0; i < last; i++)
			System.out.print(stringArray[i] + "\t");
		// To sort a test array of strings hard coded in the main method
		// Please Note that Capital letters always come before lower case
		// I tried to make the test array show its behavior clearly
	}// end Main method
}// end TreeSort class
