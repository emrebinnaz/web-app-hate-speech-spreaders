package com.example.hatespeechspreadersapp.controller;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;
import com.example.hatespeechspreadersapp.dto.TweetDTO;
import com.example.hatespeechspreadersapp.dto.TweetOwnerDTO;
import com.example.hatespeechspreadersapp.mapper.TweetMapper;
import com.example.hatespeechspreadersapp.mapper.TweetOwnerMapper;
import com.example.hatespeechspreadersapp.requests.GetTweetsOfOwnerRequest;
import com.example.hatespeechspreadersapp.response.TweetOwnerResponse;
import com.example.hatespeechspreadersapp.service.TweetOwnerService;
import com.example.hatespeechspreadersapp.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TweetOwnerController {

    private final TweetOwnerService tweetOwnerService;
    private final TweetOwnerMapper tweetOwnerMapper;

    private final TweetService tweetService;
    private final TweetMapper tweetMapper;


    @PostMapping("/{username}")
    public ResponseEntity<TweetOwnerResponse> getTweetsOfOwner(@PathVariable("username") String username,
                                                               @RequestBody() GetTweetsOfOwnerRequest request) {

        TweetOwnerResponse tweetOwnerResponse = new TweetOwnerResponse();

        Long tweetOwnerId = request.getId();

        List<Tweet> tweets = tweetService.getTweetsOfUser(tweetOwnerId);
        List<TweetDTO> tweetDTOList = tweetMapper.mapToDto(tweets);

        TweetOwner tweetOwner = tweetOwnerService.findByUsername(username);
        TweetOwnerDTO tweetOwnerDTO = tweetOwnerMapper.mapToDto(tweetOwner);

        tweetOwnerResponse.setTweetDTOList(tweetDTOList);
        tweetOwnerResponse.setTweetOwnerDTO(tweetOwnerDTO);

        tweetOwnerResponse.setMessage("Successful");
        tweetOwnerResponse.setSuccess(true);

        return ResponseEntity.ok(tweetOwnerResponse);

    }
}
