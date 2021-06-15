package com.example.hatespeechspreadersapp.repository;

import com.example.hatespeechspreadersapp.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}
