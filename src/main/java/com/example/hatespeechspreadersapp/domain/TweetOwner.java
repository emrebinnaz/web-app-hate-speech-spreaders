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
    @Column(name = "id")
    private Long id;

    @NotNull()
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull()
    @Column(name = "typeOfSpreader")
    private TypeOfSpreader typeOfSpreader;

    @NotNull()
    @Column(name = "imageUrl")
    private String imageUrl;

    @NotNull()
    @Column(name = "followers")
    private int followers;

    @NotNull()
    @Column(name = "following")
    private int following;

    @NotNull()
    @Column(name = "isMostInteractedUser")
    private boolean isMostInteractedUser;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "owner_id")
    private Set<Tweet> tweets;

}
