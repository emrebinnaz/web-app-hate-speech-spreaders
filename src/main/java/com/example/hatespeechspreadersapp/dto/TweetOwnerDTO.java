package com.example.hatespeechspreadersapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TweetOwnerDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("followers")
    private int followers;

    @JsonProperty("following")
    private int following;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("username")
    private String username;

}
