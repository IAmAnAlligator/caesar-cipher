package com.shilin.caesar.cipher.controller;

import com.shilin.caesar.cipher.util.CaesarCipher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caesar-cipher")
public class Controller {

    private final CaesarCipher CAESAR_CIPHER = new CaesarCipher();
    private final int LIMIT = 26;
    private final int ZERO = 0;

    @GetMapping("/cipher")
    public String getCipherResult(@RequestParam String input, @RequestParam int offset) {
        if (offset >= LIMIT || offset <= ZERO) {
            return "Offset is a number from 1 to 26";
        } else {
            return CAESAR_CIPHER.cipher(input, offset);
        }
    }

    @GetMapping("/decipher")
    public String getDecipherResult(@RequestParam String input, @RequestParam int offset) {
        if (offset >= LIMIT || offset <= ZERO) {
            return "Offset is a number from 1 to 26";
        } else {
            return CAESAR_CIPHER.decipher(input, offset);
        }
    }

}
