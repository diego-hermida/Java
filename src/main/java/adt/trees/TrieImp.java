package adt.trees;

//Trie Data structure implementation without any libraries */

/**
 *
 * @author Dheeraj Kumar Barnwal (https://github.com/dheeraj92)
 *
 */
import java.util.Scanner;

public class TrieImp {

	public class TrieNode {
		TrieNode[] child;
		boolean end;

		public TrieNode() {
			child = new TrieNode[26];
			end = false;
		}
	}

	private final TrieNode root;

	public TrieImp() {
		root = new TrieNode();
	}

	public void insert(final String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode node = currentNode.child[word.charAt(i) - 'a'];
			if (node == null) {
				node = new TrieNode();
				currentNode.child[word.charAt(i) - 'a'] = node;
			}
			currentNode = node;
		}
		currentNode.end = true;
	}

	public boolean search(final String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			final char ch = word.charAt(i);
			final TrieNode node = currentNode.child[ch - 'a'];
			if (node == null)
				return false;
			currentNode = node;
		}
		return currentNode.end;
	}

	public boolean delete(final String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			final char ch = word.charAt(i);
			final TrieNode node = currentNode.child[ch - 'a'];
			if (node == null)
				return false;
			currentNode = node;
		}
		if (currentNode.end == true) {
			currentNode.end = false;
			return true;
		}
		return false;
	}

	public static void sop(final String print) {
		System.out.println(print);
	}

	// Regex to check if word contains only a-z character
	public static boolean isValid(final String word) {
		return word.matches("^[a-z]+$");
	}

	public static void main(final String[] args) {
		final TrieImp obj = new TrieImp();
		String word;
		@SuppressWarnings("resource")
		final Scanner scan = new Scanner(System.in);
		sop("string should contain only a-z character for all operation");
		while (true) {
			sop("1. Insert\n2. Search\n3. Delete\n4. Quit");
			try {
				final int t = scan.nextInt();
				switch (t) {
				case 1:
					word = scan.next();
					if (isValid(word))
						obj.insert(word);
					else
						sop("Invalid string: allowed only a-z");
					break;
				case 2:
					word = scan.next();
					boolean resS = false;
					if (isValid(word))
						resS = obj.search(word);
					else
						sop("Invalid string: allowed only a-z");
					if (resS)
						sop("word found");
					else
						sop("word not found");
					break;
				case 3:
					word = scan.next();
					boolean resD = false;
					if (isValid(word))
						resD = obj.delete(word);
					else
						sop("Invalid string: allowed only a-z");
					if (resD)
						sop("word got deleted successfully");
					else
						sop("word not found");
					break;
				case 4:
					sop("Quit successfully");
					System.exit(1);
					break;
				default:
					sop("Input int from 1-4");
					break;
				}
			} catch (final Exception e) {
				final String badInput = scan.next();
				sop("This is bad input: " + badInput);
			}
		}
	}

}
