package com.example.hatespeechspreadersapp.domain;

import com.example.hatespeechspreadersapp.enums.TypeOfSpreader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Table(name = "tweet_owner")
@Entity
public class TweetOwner extends AbstractDateEntity {

    @Id
    @NotBlank()
    @Column(name = "id")
    private Long id;

    @NotBlank()
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotBlank()
    @Column(name = "typeOfSpreader")
    private TypeOfSpreader typeOfSpreader;

    @NotBlank()
    @Column(name = "imageUrl")
    private String imageUrl;

    @NotBlank()
    @Column(name = "followers")
    private int followers;

    @NotBlank()
    @Column(name = "following")
    private int following;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "owner_id")
    private Set<Tweet> tweets;

}
