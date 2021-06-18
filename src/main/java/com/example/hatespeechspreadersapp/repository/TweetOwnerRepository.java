package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.Hashtag;
import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TweetOwnerRepository extends JpaRepository<TweetOwner, Long> {

    @Query(
            value = "SELECT owner_id" +
                    "  FROM (SELECT DISTINCT ON (owner_id) owner_id,fav_count,rt_count" +
                    "      FROM (SELECT DISTINCT ON (text) text, fav_count, rt_count, owner_id" +
                    "            FROM tweet WHERE fetching_time = :today) as uniqueTweets) " +
                    "       as uniqueOwners" +
                    "  ORDER BY fav_count + rt_count DESC limit 10", nativeQuery = true)
    List<Long> getTodayTweetOwnersIds(@Param("today") LocalDate today);

    TweetOwner findByUsername(String username);

}
