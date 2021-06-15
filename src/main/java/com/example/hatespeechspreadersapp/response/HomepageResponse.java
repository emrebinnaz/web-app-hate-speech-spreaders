package com.example.hatespeechspreadersapp.response;

import com.example.hatespeechspreadersapp.dto.HashtagDTO;
import com.example.hatespeechspreadersapp.dto.TweetDTO;
import lombok.Data;

import java.util.List;

@Data
public class HomepageResponse extends BaseResponse{

    private List<TweetDTO> tweetDTOList;

    private List<HashtagDTO> hashtagDTOList;
}
