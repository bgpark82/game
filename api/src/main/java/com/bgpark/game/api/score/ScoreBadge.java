package com.bgpark.game.api.score;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class ScoreBadge {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalScore;
    private String username;
    private LocalDateTime timestamp;

    public ScoreBadge(int totalScore, String username) {
        this.totalScore = totalScore;
        this.username = username;
        this.timestamp = LocalDateTime.now();
    }
}
