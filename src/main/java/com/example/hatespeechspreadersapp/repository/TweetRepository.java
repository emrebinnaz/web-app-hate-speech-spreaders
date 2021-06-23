package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;
import com.example.hatespeechspreadersapp.enums.PlaceOfTweet;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {


    @Query(value = "SELECT * " +
                    "FROM (SELECT DISTINCT ON (text) * " +
                           "FROM TWEET WHERE fetching_time = :today AND (place_of_tweet = :stream OR place_of_tweet = :both)) as UniqueTweets" +
                    " ORDER BY created_date desc", nativeQuery = true)
    List<Tweet> getTodayTweets(@Param("today") LocalDate today,
                               @Param("stream") String stream,
                               @Param("both") String both);

    @Query(value = "SELECT * " +
                    "FROM tweet " +
                    "WHERE owner_id = :ownerId AND (place_of_tweet = :profile OR place_of_tweet = :both) " +
                    "ORDER BY created_date desc",
            nativeQuery = true)
    List<Tweet> findByTweetOwnerAndPlaceOfTweet(@Param("ownerId") Long ownerId,
                                                @Param("profile") String profile,
                                                @Param("both") String both);


    @Query(value = "SELECT * " +
                    "FROM tweet " +
                    "WHERE id IN (:idList) " +
                    "order by created_date DESC",
            nativeQuery = true)
    List<Tweet> getTweetsOfHashtag(@Param("idList") List<Long> idList);

}
