package com.bgpark.game.api.score;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Score {

    private static final int DEFAULT_SCORE = 10;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Long resultId;
    private int score;

    public Score(String username, Long resultId) {
        this.username = username;
        this.resultId = resultId;
        this.score = DEFAULT_SCORE;
    }
}
