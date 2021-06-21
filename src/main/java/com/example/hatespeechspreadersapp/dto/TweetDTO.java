package com.example.hatespeechspreadersapp.dto;

import com.example.hatespeechspreadersapp.enums.Label;
import com.example.hatespeechspreadersapp.enums.PlaceOfTweet;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TweetDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("createdDate")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDate;

    @JsonProperty("favCount")
    private int favCount;

    @JsonProperty("rtCount")
    private int rtCount;

    @JsonProperty("placeOfTweet")
    private PlaceOfTweet placeOfTweet;

    @JsonProperty("text")
    private String text;

    @JsonProperty("tweetOwner")
    private TweetOwnerDTO tweetOwner;

    @JsonProperty("label")
    private Label label;

}
