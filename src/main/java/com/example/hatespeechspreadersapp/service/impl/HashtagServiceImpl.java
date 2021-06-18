package com.example.hatespeechspreadersapp.service.impl;

import com.example.hatespeechspreadersapp.constants.Constants;
import com.example.hatespeechspreadersapp.domain.Hashtag;
import com.example.hatespeechspreadersapp.repository.HashtagRepository;
import com.example.hatespeechspreadersapp.service.HashtagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HashtagServiceImpl implements HashtagService {

    private final HashtagRepository hashtagRepository;
    @Override
    public List<Hashtag> getHashtagList() {

        log.info("Get hashtag list service is running");

        return hashtagRepository.findByFetchingTime(Constants.TODAY);

    }
}
