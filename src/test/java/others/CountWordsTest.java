package others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountWordsTest {

	@Test
	public void wordsCountTest() {

		assertEquals(-1, CountWords.wordCount(null));
		assertEquals(-1, CountWords.wordCount(""));
		assertEquals(3, CountWords.wordCount("            palabra1     palabra 2"));
		assertEquals(5, CountWords.wordCount(" saer  wer  wer 23 ���"));
		assertEquals(13, CountWords.wordCount("���� � ���� �� ��� � ���  �� � '' '' ' $%/$%1"));
		assertEquals(1, CountWords.wordCount("abcdefghijklmn�opqrstuvwxyz"));
	}
}
