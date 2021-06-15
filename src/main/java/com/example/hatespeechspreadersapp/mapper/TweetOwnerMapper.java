package com.example.hatespeechspreadersapp.mapper;

import com.example.hatespeechspreadersapp.domain.TweetOwner;
import com.example.hatespeechspreadersapp.dto.TweetOwnerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TweetOwnerMapper extends BaseMapper<TweetOwnerDTO, TweetOwner>{
}
