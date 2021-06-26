package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.Tweet;
import com.example.hatespeechspreadersapp.domain.TweetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TweetOwnerRepository extends JpaRepository<TweetOwner, Long> {

    @Query(value = "SELECT * " +
                    "FROM tweet_owner " +
                    "WHERE is_most_interacted_user = :isMostInteractedUser", nativeQuery = true)
    List<TweetOwner> findAllByMostInteractedUser(@Param("isMostInteractedUser") Boolean isMostInteractedUser);


    TweetOwner findByUsername(String username);

}
