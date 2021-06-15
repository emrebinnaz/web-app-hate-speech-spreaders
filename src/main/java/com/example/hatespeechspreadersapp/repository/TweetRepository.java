package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {


    @Query(
            value = "SELECT * " +
                    "FROM (SELECT DISTINCT ON (text) * " +
                           "FROM TWEET WHERE fetching_time = :fetchingTime) as UniqueTweets" +
                    " ORDER BY created_date desc", nativeQuery = true)
    List<Tweet> getTodayTweets(@Param("fetchingTime") LocalDate fetchingTime);

}
