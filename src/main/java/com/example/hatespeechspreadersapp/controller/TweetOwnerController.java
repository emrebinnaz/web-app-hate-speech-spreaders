package com.example.hatespeechspreadersapp.controller;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;
import com.example.hatespeechspreadersapp.dto.TweetDTO;
import com.example.hatespeechspreadersapp.dto.TweetOwnerDTO;
import com.example.hatespeechspreadersapp.mapper.TweetMapper;
import com.example.hatespeechspreadersapp.mapper.TweetOwnerMapper;
import com.example.hatespeechspreadersapp.response.TweetOwnerResponse;
import com.example.hatespeechspreadersapp.service.TweetOwnerService;
import com.example.hatespeechspreadersapp.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TweetOwnerController {

    private final TweetOwnerService tweetOwnerService;
    private final TweetOwnerMapper tweetOwnerMapper;

    private final TweetService tweetService;
    private final TweetMapper tweetMapper;


    @GetMapping("/{username}")
    public ResponseEntity<TweetOwnerResponse> getTweetsOfOwner(@PathVariable("username") String username) {

        TweetOwnerResponse tweetOwnerResponse = new TweetOwnerResponse();

        TweetOwner tweetOwner = tweetOwnerService.getTweetOwnerByUsername(username);
        TweetOwnerDTO tweetOwnerDTO = tweetOwnerMapper.mapToDto(tweetOwner);

        List<Tweet> tweets = tweetService.getTweetsOfUser(tweetOwner);
        List<TweetDTO> tweetDTOList = tweetMapper.mapToDto(tweets);


        tweetOwnerResponse.setTweetOwnerDTO(tweetOwnerDTO);
        tweetOwnerResponse.setTweetDTOList(tweetDTOList);
        tweetOwnerResponse.setMessage("Successful");
        tweetOwnerResponse.setSuccess(true);

        return ResponseEntity.ok(tweetOwnerResponse);

    }
}
