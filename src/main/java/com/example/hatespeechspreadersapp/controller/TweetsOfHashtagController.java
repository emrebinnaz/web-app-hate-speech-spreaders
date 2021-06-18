package com.example.hatespeechspreadersapp.controller;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.dto.TweetDTO;
import com.example.hatespeechspreadersapp.mapper.TweetMapper;
import com.example.hatespeechspreadersapp.requests.GetTweetsOfHashtagRequest;
import com.example.hatespeechspreadersapp.service.HashtagService;
import com.example.hatespeechspreadersapp.service.TweetsOfHashtagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TweetsOfHashtagController {

    private final TweetsOfHashtagService tweetsOfHashtagService;
    private final TweetMapper tweetMapper;


    @PostMapping("getTweetsOf/{hashtag}")
    public ResponseEntity<List<TweetDTO>> getTweetsOfHashtag(@RequestBody GetTweetsOfHashtagRequest request) {

        Long hashtagId = request.getHashtagId();
        List<Tweet> tweetsOfHashtagById = tweetsOfHashtagService.getTweetsOfHashtagById(hashtagId);
        List<TweetDTO> tweetDTOList = tweetMapper.mapToDto(tweetsOfHashtagById);

        return ResponseEntity.ok(tweetDTOList);
    }


}
