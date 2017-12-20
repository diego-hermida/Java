package others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountCharTest {

	@Test
	public void CountCharactersTest() {
		assertEquals("".length(), CountChar.CountCharacters(""));
		assertEquals("".length(), CountChar.CountCharacters(" "));
		assertEquals("saerwerwer23ñññ".length(), CountChar.CountCharacters("saerwerwer23ñññ"));
		assertEquals("ññññññÑÑÑÑÑñññÑÑññÑÑÑ'''''$%/$%1".length(),
				CountChar.CountCharacters("ññññ ñ ñÑÑÑ ÑÑ ñññ Ñ Ñññ  ÑÑ Ñ '' '' ' $%/$%1"));
		assertEquals("abcdefghijklmnñopqrstuvwxyz".length(), CountChar.CountCharacters("abcdefghijklmnñopqrstuvwxyz"));
		assertEquals("".length(), CountChar.CountCharacters("            "));
		assertEquals(0,  CountChar.CountCharacters(null));
	}
}
