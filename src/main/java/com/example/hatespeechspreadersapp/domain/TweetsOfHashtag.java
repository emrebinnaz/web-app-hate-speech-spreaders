package com.example.hatespeechspreadersapp.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "tweets_of_hashtag")
@IdClass(TweetsOfHashtagPK.class)
public class TweetsOfHashtag extends AbstractDateEntity{

    @Id
    @NotBlank()
    @ManyToOne
    @JoinColumn(name = "tweetId", referencedColumnName = "id")
    private Tweet tweet;

    @Id
    @NotBlank()
    @ManyToOne
    @JoinColumn(name = "hashtagId", referencedColumnName = "id")
    private Hashtag hashtag;

}
