package com.example.hatespeechspreadersapp.service;

import com.example.hatespeechspreadersapp.domain.TweetOwner;

import java.util.List;

public interface TweetOwnerService {

    List<TweetOwner> getTweetOwnerList();

    TweetOwner getTweetOwnerByUsername(String username);
}
