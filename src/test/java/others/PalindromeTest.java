package others;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void isPalindromeTest() {
		Palindrome palindrome = new Palindrome();
		assertFalse(palindrome.isPalindrome(null));
		assertFalse(palindrome.isPalindrome("123456798"));
		assertFalse(palindrome.isPalindrome("fjgkh"));
		assertTrue(palindrome.isPalindrome("reconocer"));
		assertTrue(palindrome.isPalindrome("recOnoCer"));
		assertTrue(palindrome.isPalindrome("somos"));
		assertTrue(palindrome.isPalindrome("121"));
		//assertTrue(palindrome.isPalindrome("Satan oscillate my metallic sonatas"));

	}
}
