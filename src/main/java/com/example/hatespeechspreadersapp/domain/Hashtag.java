package com.example.hatespeechspreadersapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@Table(name = "hashtag")
@Entity
public class Hashtag extends AbstractDateEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotBlank()
    @Column(name = "id")
    private Long id;

    @NotBlank()
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "hashtag",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TweetsOfHashtag> tweetsOfHashtags;
}
