package com.example.hatespeechspreadersapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HashtagDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
