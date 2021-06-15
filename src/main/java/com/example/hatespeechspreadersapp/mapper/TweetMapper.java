package com.example.hatespeechspreadersapp.mapper;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.dto.TweetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TweetOwnerMapper.class})
public interface TweetMapper extends BaseMapper<TweetDTO, Tweet>{

    @Mapping(source = "tweetOwner", target = "tweetOwner")
    TweetDTO mapToDto(Tweet tweet);

}
