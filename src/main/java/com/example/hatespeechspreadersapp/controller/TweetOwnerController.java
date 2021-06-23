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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TweetOwnerController {

    private final TweetOwnerService tweetOwnerService;
    private final TweetOwnerMapper tweetOwnerMapper;

    private final TweetService tweetService;
    private final TweetMapper tweetMapper;


    @PostMapping("/getTweetsOfOwner")
    public ResponseEntity<TweetOwnerResponse> getTweetsOfOwner(@RequestBody() GetTweetsOfOwnerRequest request) {

        TweetOwnerResponse tweetOwnerResponse = new TweetOwnerResponse();

        Long ownerId = request.getId();
        List<Tweet> tweets = tweetService.getTweetsOfUser(ownerId);
        List<TweetDTO> tweetDTOList = tweetMapper.mapToDto(tweets);

        Optional<TweetOwner> optionalTweetOwner = tweetOwnerService.findById(ownerId);

        if(optionalTweetOwner.isPresent()) {
            TweetOwnerDTO tweetOwnerDTO = tweetOwnerMapper.mapToDto(optionalTweetOwner.get());
            tweetOwnerResponse.setTweetOwnerDTO(tweetOwnerDTO);
        }

        tweetOwnerResponse.setTweetDTOList(tweetDTOList);


        tweetOwnerResponse.setMessage("Successful");
        tweetOwnerResponse.setSuccess(true);

        return ResponseEntity.ok(tweetOwnerResponse);

    }
}
