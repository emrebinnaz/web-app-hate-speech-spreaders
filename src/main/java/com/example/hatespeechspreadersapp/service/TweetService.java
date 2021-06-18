package com.example.hatespeechspreadersapp.service;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;

import java.util.List;

public interface TweetService {

    List<Tweet> getTweets();

    List<Tweet> getTweetsOfUser(TweetOwner tweetOwner);
}
