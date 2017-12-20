package others;

/**
 * You enter a string into this program, and it will return how many words were
 * in that particular string. Returns -1 if there are no words
 *
 * @author Marcus
 *
 */
class CountWords {

	public static int wordCount(String s) {
		if ((s == null) || s.isEmpty())
			return -1;
		return s.trim().split("[\\s]+").length;
	}

}
