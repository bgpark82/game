package com.bgpark.game.api.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class ScoreRepositoryTest {

    @Autowired
    private ScoreRepository scoreRepository;

    @BeforeEach
    void setUp() {
        scoreRepository.deleteAll();
    }

    @Test
    void saveScore() {
        Score score = new Score(null, "bgpark", 1L, 10);
        Score savedScore = scoreRepository.save(score);

        assertThat(savedScore.getScore()).isEqualTo(10);
        assertThat(savedScore.getResultId()).isEqualTo(1L);
        assertThat(savedScore.getUsername()).isEqualTo("bgpark");
    }

    @Test
    void getTotalScore() {
        List<Score> scores = Arrays.asList(
                new Score(null, "bgpark", 1L, 10),
                new Score(null, "bgpark", 1L, 10),
                new Score(null, "bgpark", 1L, 10),
                new Score(null, "bgpark", 1L, 10)
        );
        scoreRepository.saveAll(scores);

        int total = scoreRepository.getTotalScoreByUsername("bgpark");

        assertThat(total).isEqualTo(40);
    }

    @Test
    void getTotalScoreNull() {
        assertThatThrownBy(() -> {
            scoreRepository.getTotalScoreByUsername("bgpark");
        }).isInstanceOf(AopInvocationException.class);
    }

    @Test
    void getTotalScoresByUsernameNull() {
        List<Score> scores = scoreRepository.findAllByUsername("bgpark");
        assertThat(scores.size()).isEqualTo(0);
    }
}