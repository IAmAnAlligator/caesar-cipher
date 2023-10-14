package com.example.CaesarCipher.Controller;

import com.example.CaesarCipher.Record;
import com.example.CaesarCipher.Util.CaesarCipher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caesar-cipher")
public class Controller {

    @GetMapping("/cipher")
    public String getCipherResult(@RequestParam String input, @RequestParam int offset) {
        CaesarCipher.addRecord(input, offset);
        return CaesarCipher.cipher(input, offset);
    }

    @GetMapping("/decipher")
    public String getDecipherResult(@RequestParam String input, @RequestParam int offset) {
        return CaesarCipher.decipher(input, offset);
    }

    @GetMapping("/log")
    public List<Record> getLog() {
        return CaesarCipher.getRecords();
    }
}
