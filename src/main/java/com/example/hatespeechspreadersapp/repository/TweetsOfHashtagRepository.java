package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.TweetsOfHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsOfHashtagRepository extends JpaRepository<TweetsOfHashtag, Long> {

}
