package com.shilin.caesar.cipher.util;

public class CaesarCipher {

    private final int LIMIT = 26;
    private final char CHAR_A_UPPERCASE = 'A';
    private final char CHAR_Z_UPPERCASE = 'Z';
    private final char CHAR_A_LOWERCASE = 'a';
    private final char CHAR_Z_LOWERCASE = 'z';

    public String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (isAlphabeticalCharacter(character)) {
                if(isLowercaseCharacter(character)) {
                    int originalAlphabetPosition = character - CHAR_A_LOWERCASE;
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % LIMIT;
                    char newCharacter = (char) (CHAR_A_LOWERCASE + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    int originalAlphabetPosition = character - CHAR_A_UPPERCASE;
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % LIMIT;
                    char newCharacter = (char) (CHAR_A_UPPERCASE + newAlphabetPosition);
                    result.append(newCharacter);
                }
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public String decipher(String message, int offset) {
        return cipher(message, LIMIT - (offset % LIMIT));
    }

    private boolean isAlphabeticalCharacter(char character) {
        return character >= CHAR_A_UPPERCASE && character <= CHAR_Z_UPPERCASE ||
                character >= CHAR_A_LOWERCASE && character <= CHAR_Z_LOWERCASE;
    }

    private boolean isLowercaseCharacter(char character) {
        return character >= CHAR_A_LOWERCASE && character <= CHAR_Z_LOWERCASE;
    }
}
