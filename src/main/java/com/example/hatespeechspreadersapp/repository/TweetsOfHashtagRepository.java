package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.TweetsOfHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetsOfHashtagRepository extends JpaRepository<TweetsOfHashtag, Long> {


    @Query(value = "SELECT tweet_id " +
                   "FROM tweets_of_hashtag " +
                   "WHERE hashtag_id = :hashtagId", nativeQuery = true)
    List<Long> getTweetIdListOfHashtag(@Param("hashtagId") Long hashtagId);
}
