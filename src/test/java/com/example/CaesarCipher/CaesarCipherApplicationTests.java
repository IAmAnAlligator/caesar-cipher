package com.example.CaesarCipher;

import com.example.CaesarCipher.Util.CaesarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CaesarCipherApplicationTests {

	private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private final String alphabetOffset = "defghijklmnopqrstuvwxyzabc";

	private final int offset = 3;

	@Test
	void cipherTestLowercase() {
		Assertions.assertEquals(alphabetOffset, CaesarCipher.cipher(alphabet, offset));
	}

	@Test
	void cipherTestUppercase() {
		Assertions.assertEquals(alphabetOffset.toUpperCase(), CaesarCipher.cipher(alphabet.toUpperCase(), offset));
	}

	@Test
	void decipherTestLowercase() {
		Assertions.assertEquals(alphabet, CaesarCipher.decipher(alphabetOffset, offset));
	}

	@Test
	void decipherTestUppercase() {
		Assertions.assertEquals(alphabet.toUpperCase(), CaesarCipher.decipher(alphabetOffset.toUpperCase(), offset));
	}

}
