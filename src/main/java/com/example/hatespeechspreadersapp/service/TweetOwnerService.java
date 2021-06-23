package com.example.hatespeechspreadersapp.service;

import com.example.hatespeechspreadersapp.domain.TweetOwner;

import java.util.List;
import java.util.Optional;

public interface TweetOwnerService {

    List<TweetOwner> getTweetOwnerList();

    Optional<TweetOwner> findById(Long id);
}
