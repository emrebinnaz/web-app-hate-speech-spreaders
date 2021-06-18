package com.example.hatespeechspreadersapp.service.impl;

import com.example.hatespeechspreadersapp.constants.Constants;
import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;
import com.example.hatespeechspreadersapp.repository.TweetOwnerRepository;
import com.example.hatespeechspreadersapp.service.TweetOwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TweetOwnerServiceImpl implements TweetOwnerService {

    private final TweetOwnerRepository tweetOwnerRepository;

    @Override
    public List<TweetOwner> getTweetOwnerList() {

        log.info("Get tweet owner list service is running");

        List<Long> todayTweetOwnersIds = tweetOwnerRepository.getTodayTweetOwnersIds(Constants.TODAY);

        return tweetOwnerRepository.findAllById(todayTweetOwnersIds);

    }

    @Override
    public TweetOwner findByUsername(String username) {

        log.info("Get tweet owner id by username service is running");

        return tweetOwnerRepository.findByUsername(username);
    }
}
