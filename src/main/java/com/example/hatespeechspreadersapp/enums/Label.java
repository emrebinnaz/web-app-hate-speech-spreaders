package com.example.hatespeechspreadersapp.enums;

import lombok.Getter;

@Getter
public enum Label {

    HATEFUL("HATEFUL"),
    NORMAL("NORMAL");

    private String textForm;

    Label(String textForm) { this.textForm = textForm; }

}
