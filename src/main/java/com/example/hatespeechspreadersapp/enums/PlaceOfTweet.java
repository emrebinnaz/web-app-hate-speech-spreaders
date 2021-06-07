package com.example.hatespeechspreadersapp.enums;

import lombok.Getter;

@Getter
public enum PlaceOfTweet {

    STREAM("HATEFUL"),
    PROFILE("NORMAL"),
    BOTH("BOTH");

    private String textForm;

    PlaceOfTweet(String textForm) { this.textForm = textForm; }

}
