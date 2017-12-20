package others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountCharTest {

	@Test
	public void CountCharactersTest() {
		assertEquals("".length(), CountChar.CountCharacters(""));
		assertEquals("".length(), CountChar.CountCharacters(" "));
		assertEquals("saerwerwer23���".length(), CountChar.CountCharacters("saerwerwer23���"));
		assertEquals("���������������������'''''$%/$%1".length(),
				CountChar.CountCharacters("���� � ���� �� ��� � ���  �� � '' '' ' $%/$%1"));
		assertEquals("abcdefghijklmn�opqrstuvwxyz".length(), CountChar.CountCharacters("abcdefghijklmn�opqrstuvwxyz"));
		assertEquals("".length(), CountChar.CountCharacters("            "));
		assertEquals(0,  CountChar.CountCharacters(null));
	}
}
