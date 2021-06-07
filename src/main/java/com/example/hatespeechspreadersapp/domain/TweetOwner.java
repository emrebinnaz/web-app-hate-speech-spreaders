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
@EqualsAndHashCode(of = "id")
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

    @Enumerated(EnumType.STRING)
    @NotBlank()
    @Column(name = "type_of_spreader")
    private TypeOfSpreader typeOfSpreader;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tweet_id")
    private Set<Tweet> tweets;

}
