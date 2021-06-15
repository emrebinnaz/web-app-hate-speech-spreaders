package com.example.hatespeechspreadersapp.domain;

import com.example.hatespeechspreadersapp.enums.Label;
import com.example.hatespeechspreadersapp.enums.PlaceOfTweet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tweet")
@Entity
public class Tweet extends AbstractDateEntity {

    @Id
    @NotBlank
    @Column(name = "id")
    private Long id;

    @Column(name = "createdDate")
    @NotBlank
    private LocalDateTime createdDate;

    @NotBlank()
    @Column(name = "favCount")
    private int favCount;

    @NotBlank()
    @Column(name = "rtCount")
    private int rtCount;

    @NotBlank()
    @Column(name = "text")
    private String text;

    @NotBlank()
    @Column(name = "placeOfTweet")
    @Enumerated(EnumType.STRING)
    private PlaceOfTweet placeOfTweet;

    @NotBlank()
    @Column(name = "label")
    @Enumerated(EnumType.STRING)
    private Label label;

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private TweetOwner tweetOwner;

    @OneToMany(mappedBy = "tweet",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TweetsOfHashtag> tweetsOfHashtags;

}
