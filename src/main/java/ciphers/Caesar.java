package ciphers;

/**
Author : FAHRI YARDIMCI

A Java implementation of Caesar Cipher.
/It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. /
**/
import java.util.Scanner;

public class Caesar {
	public static String encode(final String message, final int shift) {
		String encoded = "";
		for (int i = 0; i < message.length(); i++) {
			/*
			 * using char to shift characters because ascii is in-order latin
			 * alphabet
			 */
			final int current = message.charAt(i);
			if (current == 32) {
				encoded += " ";
				continue;

			} else if ((current >= 65) && (current <= 90)) {
				final int numAlphabet = message.charAt(i);
				if ((shift + numAlphabet) > 90) {
					final int j = 90 - numAlphabet;
					final char nextKey = (char) (65 + (shift - j - 1));
					encoded += nextKey;

				} else {
					final char nextKey = (char) (current + shift);
					encoded += nextKey;
				}
			} else if ((current >= 97) && (current <= 122)) {
				final int numAlphabet = message.charAt(i);
				if ((shift + numAlphabet) > 122) {
					final int j = 122 - numAlphabet;
					final char nextKey = (char) (97 + (shift - j - 1));
					encoded += nextKey;
				} else {
					final char nextKey = (char) (current + shift);
					encoded += nextKey;
				}
			}
		}
		return encoded;
	}

	public static String decode(final String message, final int shift) {
		String decoded = "";
		for (int i = 0; i < message.length(); i++) {
			final int current = message.charAt(i);
			if (current == 32) {
				decoded += " ";
				continue;

			} else if ((current >= 65) && (current <= 90)) {
				final int numAlphabet = message.charAt(i);
				if ((numAlphabet - shift) < 65) {
					final int j = numAlphabet - 65;
					final char nextKey = (char) (90 - (shift - j - 1));
					decoded += nextKey;

				} else {
					final char nextKey = (char) (current - shift);
					decoded += nextKey;
				}
			} else if ((current >= 97) && (current <= 122)) {
				final int numAlphabet = message.charAt(i);
				if ((numAlphabet - shift) < 97) {
					final int j = numAlphabet - 97;
					final char nextKey = (char) (122 - (shift - j - 1));
					decoded += nextKey;
				} else {
					final char nextKey = (char) (current - shift);
					decoded += nextKey;
				}
			}
		}
		return decoded;
	}

	public static void main(final String[] args) {
		final Scanner input = new Scanner(System.in);
		System.out.println("Please enter the message (Latin Alphabet)");
		final String message = input.nextLine();
		System.out.println(message);
		System.out.println("Please enter the shift number");
		final int shift = input.nextInt() % 26;
		System.out.println("(E)ncode or (D)ecode ?");
		final char choice = input.next().charAt(0);
		if ((choice == 'E') || (choice == 'e'))
			// send our function to handle
			System.out.println(
					"ENCODED MESSAGE IS \n" + Caesar.encode(message, shift));
		if ((choice == 'D') || (choice == 'd'))
			System.out.println(
					"DECODED MESSAGE IS \n" + Caesar.decode(message, shift));
	}

}