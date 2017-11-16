package adt.graphs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Implementation of a Breadth First Search
 *
 * @author Unknown
 *
 */
public class BFS {

	/**
	 * The BFS implemented in code to use.
	 *
	 * @param a
	 *            Structure to perform the search on a graph, adjacency matrix
	 *            etc.
	 * @param vertices
	 *            The vertices to use
	 * @param source
	 *            The Source
	 */
	public static void bfsImplement(final byte[][] a, final int vertices,
			final int source) { // passing adjacency matrix and no of vertices
		final byte[] b = new byte[vertices]; // flag container containing status
												// of each vertices
		Arrays.fill(b, (byte) -1); // status initialization
		/*
		 * code status -1 = ready 0 = waiting 1 = processed
		 */

		final Stack st = new Stack(vertices); // operational stack
		st.push(source); // assigning source
		while (!st.isEmpty()) {
			b[st.peek()] = (byte) 0; // assigning waiting status
			System.out.println(st.peek());
			final int pop = st.peek();
			b[pop] = (byte) 1; // assigning processed status
			st.pop(); // removing head of the queue
			for (int i = 0; i < vertices; i++)
				if ((a[pop][i] != 0) && (b[i] != (byte) 0)
						&& (b[i] != (byte) 1)) {
					st.push(i);
					b[i] = (byte) 0; // assigning waiting status
				}
		}
	}

	/**
	 * The main method
	 *
	 * @param args
	 *            Command line arguments
	 */
	public static void main(final String args[]) {
		final Scanner in = new Scanner(System.in);
		final int vertices = in.nextInt(), source = in.nextInt();
		final byte[][] a = new byte[vertices][vertices];
		// initially all elements of a are initialized with value zero

		for (int i = 0; i < vertices; i++) {
			final int size = in.nextInt();
			for (int j = 0; j < size; j++)
				a[i][in.nextInt()] = 1; // taking adjacency entries by assigning
										// 1
		}
		bfs.bfsImplement(a, vertices, source); // function call
		in.close();
	}
}
