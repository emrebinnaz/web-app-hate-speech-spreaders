package com.example.hatespeechspreadersapp.response;

import com.example.hatespeechspreadersapp.dto.TweetDTO;
import com.example.hatespeechspreadersapp.dto.TweetOwnerDTO;
import lombok.Data;

import java.util.List;

@Data
public class TweetOwnerResponse extends BaseResponse{

    private List<TweetDTO> tweetDTOList;

    private TweetOwnerDTO tweetOwnerDTO;
}
