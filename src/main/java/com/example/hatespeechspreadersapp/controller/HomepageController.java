package com.example.hatespeechspreadersapp.controller;

import com.example.hatespeechspreadersapp.domain.Hashtag;
import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.dto.HashtagDTO;
import com.example.hatespeechspreadersapp.dto.TweetDTO;
import com.example.hatespeechspreadersapp.mapper.HashtagMapper;
import com.example.hatespeechspreadersapp.mapper.TweetMapper;
import com.example.hatespeechspreadersapp.response.HomepageResponse;
import com.example.hatespeechspreadersapp.service.HashtagService;
import com.example.hatespeechspreadersapp.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomepageController {

    private final TweetMapper tweetMapper;
    private final TweetService tweetService;
    private final HashtagService hashtagService;
    private final HashtagMapper hashtagMapper;

    @GetMapping("/")
    public ResponseEntity<HomepageResponse> getHomepage() {

        final HomepageResponse response = new HomepageResponse();

        final List<Tweet> tweets = tweetService.getTweets();
        final List<TweetDTO> tweetDTOS = tweetMapper.mapToDto(tweets);

        final List<Hashtag> hashtags = hashtagService.getHashtagList();
        final List<HashtagDTO> hashtagDTOS = hashtagMapper.mapToDto(hashtags);

        response.setMessage("Successful");
        response.setSuccess(true);
        response.setTweetDTOList(tweetDTOS);
        response.setHashtagDTOList(hashtagDTOS);

        return ResponseEntity.ok(response);

    }
}
