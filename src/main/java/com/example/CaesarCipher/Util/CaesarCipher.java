package com.example.CaesarCipher.Util;

import com.example.CaesarCipher.Record;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {

    private static final List<Record> log = new ArrayList<>();

    public static List<Record> getRecords() {
        return log;
    }

    public static void addRecord(String message, int offset) {
        log.add(new Record(LocalDateTime.now(), message, decipher(message, offset)));
    }

    public static String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (isAlphabeticalCharacter(character)) {
                if(isLowercaseCharacter(character)) {
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                } else if(isUppercaseCharacter(character)) {
                    int originalAlphabetPosition = character - 'A';
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                    char newCharacter = (char) ('A' + newAlphabetPosition);
                    result.append(newCharacter);
                }
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String decipher(String message, int offset) {
        return cipher(message, 26 - (offset % 26));
    }

    private static boolean isAlphabeticalCharacter(char character) {
        return character >= 65 && character <= 90 ||
                character >= 97 && character <= 122;
    }

    private static boolean isLowercaseCharacter(char character) {
        return character >= 97 && character <= 122;
    }

    private static boolean isUppercaseCharacter(char character) {
        return character >= 65 && character <= 90;
    }



}
