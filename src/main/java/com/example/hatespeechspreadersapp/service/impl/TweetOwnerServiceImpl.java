package com.example.hatespeechspreadersapp.service.impl;

import com.example.hatespeechspreadersapp.domain.TweetOwner;
import com.example.hatespeechspreadersapp.repository.TweetOwnerRepository;
import com.example.hatespeechspreadersapp.service.TweetOwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TweetOwnerServiceImpl implements TweetOwnerService {

    private final TweetOwnerRepository tweetOwnerRepository;

    @Override
    public List<TweetOwner> getTweetOwnerList() {

        log.info("Get tweet owner list service is running");

        return tweetOwnerRepository.findAllByMostInteractedUser(true);
    }

    @Override
    public Optional<TweetOwner> findById(Long id) {

        log.info("Get tweet owner id by id service is running");

        return tweetOwnerRepository.findById(id);
    }
}
