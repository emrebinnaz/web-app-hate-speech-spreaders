package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.Hashtag;
import com.example.hatespeechspreadersapp.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    List<Hashtag> findByFetchingTime(LocalDate today);
}