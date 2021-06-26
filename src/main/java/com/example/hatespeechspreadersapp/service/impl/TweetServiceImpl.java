package com.example.hatespeechspreadersapp.service.impl;

import com.example.hatespeechspreadersapp.constants.Constants;
import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;
import com.example.hatespeechspreadersapp.enums.Label;
import com.example.hatespeechspreadersapp.enums.PlaceOfTweet;
import com.example.hatespeechspreadersapp.enums.TypeOfSpreader;
import com.example.hatespeechspreadersapp.repository.TweetOwnerRepository;
import com.example.hatespeechspreadersapp.repository.TweetRepository;
import com.example.hatespeechspreadersapp.service.TweetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;
    private final TweetOwnerRepository tweetOwnerRepository;

    @Override
    public List<Tweet> getTweets() {

        log.info("Get tweets service is running");

        PlaceOfTweet stream = PlaceOfTweet.STREAM;
        PlaceOfTweet both = PlaceOfTweet.BOTH;

        return tweetRepository.getTodayTweets(Constants.TODAY, stream.getTextForm(), both.getTextForm());

    }

    @Override
    @Transactional
    public List<Tweet> getTweetsOfUser(String tweetOwnerUsername) {

        log.info("Get tweets of user service is running");

        TweetOwner tweetOwner = tweetOwnerRepository.findByUsername(tweetOwnerUsername);
        PlaceOfTweet profile = PlaceOfTweet.PROFILE;
        PlaceOfTweet both = PlaceOfTweet.BOTH;
        List<Tweet> tweetsOfUser = tweetRepository.findByTweetOwnerAndPlaceOfTweet(tweetOwner.getId(),
                                                                                   profile.getTextForm(),
                                                                                   both.getTextForm());


        setTypeOfSpreader(tweetsOfUser, tweetOwner);
        tweetOwnerRepository.save(tweetOwner);
        
        return tweetsOfUser;
    }


    private void setTypeOfSpreader(List<Tweet> tweets, TweetOwner tweetOwner) {

        int hatefulTweetCount = 0;
        for(Tweet tweet : tweets) {
            if(tweet.getLabel().equals(Label.HATEFUL)) {
                hatefulTweetCount++;
            }
        }

        double hatefulRatio = (double)  hatefulTweetCount  / tweets.size();

        if(hatefulRatio >= Constants.LIMIT_OF_HATE_SPEECH_SPREADER){

            tweetOwner.setTypeOfSpreader(TypeOfSpreader.HATE);
        }
        else{
            if(hatefulRatio >= Constants.LIMIT_OF_ALMOST_HATE_SPEECH_SPREADER){
                tweetOwner.setTypeOfSpreader(TypeOfSpreader.ALMOST_HATE);
            }
            else{
                tweetOwner.setTypeOfSpreader(TypeOfSpreader.NORMAL);
            }
        }

    }
}
