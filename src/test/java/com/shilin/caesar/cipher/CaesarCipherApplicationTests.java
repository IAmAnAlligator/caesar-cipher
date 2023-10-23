package com.shilin.caesar.cipher;

import com.shilin.caesar.cipher.util.CaesarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CaesarCipherApplicationTests {

	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private final String ALPHABET_OFFSET = "defghijklmnopqrstuvwxyzabc";
	private final int OFFSET = 3;

	private static CaesarCipher caesarCipher;

	@BeforeAll
	public static void createNewCipher() {
		caesarCipher = new CaesarCipher();
	}

	@Test
	void cipherTestLowercase() {
		Assertions.assertEquals(ALPHABET_OFFSET, caesarCipher.cipher(ALPHABET, OFFSET));
	}

	@Test
	void cipherTestUppercase() {
		Assertions.assertEquals(ALPHABET_OFFSET.toUpperCase(), caesarCipher.cipher(ALPHABET.toUpperCase(), OFFSET));
	}

	@Test
	void decipherTestLowercase() {
		Assertions.assertEquals(ALPHABET, caesarCipher.decipher(ALPHABET_OFFSET, OFFSET));
	}

	@Test
	void decipherTestUppercase() {
		Assertions.assertEquals(ALPHABET.toUpperCase(), caesarCipher.decipher(ALPHABET_OFFSET.toUpperCase(), OFFSET));
	}

}
