package com.example.hatespeechspreadersapp.mapper;

import com.example.hatespeechspreadersapp.domain.Hashtag;
import com.example.hatespeechspreadersapp.dto.HashtagDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HashtagMapper  extends BaseMapper<HashtagDTO, Hashtag>{

}
