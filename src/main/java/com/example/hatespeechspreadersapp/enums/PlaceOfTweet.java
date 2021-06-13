package com.example.hatespeechspreadersapp.enums;

import lombok.Getter;

@Getter
public enum PlaceOfTweet {

    STREAM("STREAM"),
    PROFILE("PROFILE"),
    BOTH("BOTH");

    private String textForm;

    PlaceOfTweet(String textForm) { this.textForm = textForm; }

}
