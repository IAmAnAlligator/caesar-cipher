package com.example.CaesarCipher;

import java.time.LocalDateTime;

public class Record {

    private LocalDateTime dateTime;

    private String cipherString;

    private String decipherString;

    public Record(LocalDateTime dateTime, String cipherString, String decipherString) {
        this.dateTime = dateTime;
        this.cipherString = cipherString;
        this.decipherString = decipherString;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCipherString() {
        return cipherString;
    }

    public void setCipherString(String cipherString) {
        this.cipherString = cipherString;
    }

    public String getDecipherString() {
        return decipherString;
    }

    public void setDecipherString(String decipherString) {
        this.decipherString = decipherString;
    }
}
