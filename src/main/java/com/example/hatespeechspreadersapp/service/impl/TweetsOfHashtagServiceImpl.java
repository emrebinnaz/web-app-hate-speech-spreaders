package com.example.hatespeechspreadersapp.service.impl;

import com.example.hatespeechspreadersapp.constants.Constants;
import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetsOfHashtag;
import com.example.hatespeechspreadersapp.repository.TweetRepository;
import com.example.hatespeechspreadersapp.repository.TweetsOfHashtagRepository;
import com.example.hatespeechspreadersapp.service.TweetsOfHashtagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TweetsOfHashtagServiceImpl implements TweetsOfHashtagService {

    private final TweetsOfHashtagRepository tweetsOfHashtagRepository;
    private final TweetRepository tweetRepository;

    @Override
    public List<Tweet> getTweetsOfHashtagById(Long hashtagId) {

        log.info("Get tweets of hashtag by id service is running");
        List<Long> tweetIdListOfHashtag = tweetsOfHashtagRepository.getTweetIdListOfHashtag(hashtagId);
        return tweetRepository.getTweetsOfHashtag(tweetIdListOfHashtag);

    }
}
