package others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountWordsTest {

	@Test
	public void wordsCountTest() {

		assertEquals(-1, CountWords.wordCount(null));
		assertEquals(-1, CountWords.wordCount(""));
		assertEquals(3, CountWords.wordCount("            palabra1     palabra 2"));
		assertEquals(5, CountWords.wordCount(" saer  wer  wer 23 ñññ"));
		assertEquals(13, CountWords.wordCount("ññññ ñ ñÑÑÑ ÑÑ ñññ Ñ Ñññ  ÑÑ Ñ '' '' ' $%/$%1"));
		assertEquals(1, CountWords.wordCount("abcdefghijklmnñopqrstuvwxyz"));
	}
}
