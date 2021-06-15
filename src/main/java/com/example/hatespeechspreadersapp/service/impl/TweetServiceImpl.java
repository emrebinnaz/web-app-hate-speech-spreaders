package com.example.hatespeechspreadersapp.service.impl;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.repository.TweetRepository;
import com.example.hatespeechspreadersapp.service.TweetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    @Override
    public List<Tweet> getTweets() {

        log.info("Get tweets service is running");

        LocalDate today = LocalDate.now();

        return tweetRepository.getTodayTweets(today);

    }
}
