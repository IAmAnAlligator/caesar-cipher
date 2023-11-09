package com.shilin.caesar.cipher.controller;

import com.shilin.caesar.cipher.util.CaesarCipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caesar-cipher")
public class Controller {

    private static final int LIMIT = 26;
    private static final int ZERO = 0;

    private final CaesarCipher caesarCipher;

    @Autowired
    public Controller(CaesarCipher caesarCipher) {
        this.caesarCipher = caesarCipher;
    }

    @GetMapping("/cipher")
    public String getCipherResult(@RequestParam String input, @RequestParam int offset) {
        if (offset >= LIMIT || offset <= ZERO) {
            return "Offset is a number from 1 to 26";
        } else {
            return caesarCipher.cipher(input, offset);
        }
    }

    @GetMapping("/decipher")
    public String getDecipherResult(@RequestParam String input, @RequestParam int offset) {
        if (offset >= LIMIT || offset <= ZERO) {
            return "Offset is a number from 1 to 26";
        } else {
            return caesarCipher.decipher(input, offset);
        }
    }

}
