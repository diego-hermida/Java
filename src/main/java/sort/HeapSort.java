package sort;

import java.util.Scanner;

/**
 * Heap Sort Algorithm Implements MinHeap
 *
 * @author Unknown
 *
 */
public class HeapSort {
	/** Array to store heap */
	private int[] heap;
	/** The size of the heap */
	private int size;

	/**
	 * Constructor
	 *
	 * @param heap
	 *            array of unordered integers
	 */
	public HeapSort(final int[] heap) {
		setHeap(heap);
		setSize(heap.length);
	}

	/**
	 * Setter for variable size
	 *
	 * @param length
	 *            new size
	 */
	private void setSize(final int length) {
		size = length;
	}

	/**
	 * Setter for variable heap
	 *
	 * @param heap
	 *            array of unordered elements
	 */
	private void setHeap(final int[] heap) {
		this.heap = heap;
	}

	/**
	 * Swaps index of first with second
	 *
	 * @param first
	 *            First index to switch
	 * @param second
	 *            Second index to switch
	 */
	private void swap(final int first, final int second) {
		final int temp = heap[first];
		heap[first] = heap[second];
		heap[second] = temp;
	}

	/**
	 * Heapifies subtree from top as root to last as last child
	 *
	 * @param rootIndex
	 *            index of root
	 * @param lastChild
	 *            index of last child
	 */
	private void heapSubtree(final int rootIndex, final int lastChild) {
		final int leftIndex = (rootIndex * 2) + 1;
		final int rightIndex = (rootIndex * 2) + 2;
		final int root = heap[rootIndex];
		if (rightIndex <= lastChild) { // if has right and left children
			final int left = heap[leftIndex];
			final int right = heap[rightIndex];
			if ((left < right) && (left < root)) {
				swap(leftIndex, rootIndex);
				heapSubtree(leftIndex, lastChild);
			} else if (right < root) {
				swap(rightIndex, rootIndex);
				heapSubtree(rightIndex, lastChild);
			}
		} else if (leftIndex <= lastChild) { // if no right child, but has left
												// child
			final int left = heap[leftIndex];
			if (left < root) {
				swap(leftIndex, rootIndex);
				heapSubtree(leftIndex, lastChild);
			}
		}
	}

	/**
	 * Makes heap with root as root
	 *
	 * @param root
	 *            index of root of heap
	 */
	private void makeMinHeap(final int root) {
		final int leftIndex = (root * 2) + 1;
		final int rightIndex = (root * 2) + 2;
		final boolean hasLeftChild = leftIndex < heap.length;
		final boolean hasRightChild = rightIndex < heap.length;
		if (hasRightChild) { // if has left and right
			makeMinHeap(leftIndex);
			makeMinHeap(rightIndex);
			heapSubtree(root, heap.length - 1);
		} else if (hasLeftChild)
			heapSubtree(root, heap.length - 1);
	}

	/**
	 * Gets the root of heap
	 *
	 * @return root of heap
	 */
	private int getRoot() {
		swap(0, size - 1);
		size--;
		heapSubtree(0, size - 1);
		return heap[size]; // return old root
	}

	/**
	 * Sorts heap with heap sort; displays ordered elements to console.
	 *
	 * @return sorted array of sorted elements
	 */
	public final int[] sort() {
		makeMinHeap(0); // make min heap using index 0 as root.
		final int[] sorted = new int[size];
		int index = 0;
		while (size > 0) {
			final int min = getRoot();
			sorted[index] = min;
			index++;
		}
		return sorted;
	}

	/**
	 * Gets input to sort
	 *
	 * @return unsorted array of integers to sort
	 */
	public static int[] getInput() {
		final int numElements = 6;
		final int[] unsorted = new int[numElements];
		final Scanner input = new Scanner(System.in);
		System.out.println("Enter any 6 Numbers for Unsorted Array : ");
		for (int i = 0; i < numElements; i++)
			unsorted[i] = input.nextInt();
		input.close();
		return unsorted;
	}

	/**
	 * Prints elements in heap
	 *
	 * @param heap
	 *            array representing heap
	 */
	public static void printData(final int[] heap) {
		System.out.println("Sorted Elements:");
		for (final int element : heap)
			System.out.print(" " + element + " ");
	}

	/**
	 * Main method
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args) {
		final int[] heap = HeapSort.getInput();
		final HeapSort data = new HeapSort(heap);
		final int[] sorted = data.sort();
		HeapSort.printData(sorted);
	}

}
