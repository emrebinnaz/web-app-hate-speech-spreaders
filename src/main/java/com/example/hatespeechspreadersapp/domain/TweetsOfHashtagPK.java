package com.example.hatespeechspreadersapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetsOfHashtagPK implements Serializable {

    private Tweet tweet;
    private Hashtag hashtag;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TweetsOfHashtagPK that = (TweetsOfHashtagPK) o;
        return Objects.equals(tweet, that.tweet) &&
                Objects.equals(hashtag, that.hashtag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tweet, this.hashtag);
    }
}
