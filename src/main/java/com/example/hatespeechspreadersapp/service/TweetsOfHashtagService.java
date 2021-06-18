package com.example.hatespeechspreadersapp.service;

import com.example.hatespeechspreadersapp.domain.Tweet;

import java.util.List;

public interface TweetsOfHashtagService {

    List<Tweet> getTweetsOfHashtagById(Long hashtagId);
}
