package com.example.hatespeechspreadersapp.enums;

import lombok.Getter;

@Getter
public enum TypeOfSpreader {

    HATE("HATE"),
    ALMOST_HATE("ALMOST_HATE"),
    NORMAL("NORMAL");

    private String textForm;

    TypeOfSpreader(String textForm) { this.textForm = textForm; }

}
