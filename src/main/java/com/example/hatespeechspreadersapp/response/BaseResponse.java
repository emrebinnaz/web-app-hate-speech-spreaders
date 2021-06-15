package com.example.hatespeechspreadersapp.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse {

    private boolean success;
    private String message;

}
