package com.bgpark.game.score.service;

import com.bgpark.game.api.score.Score;
import com.bgpark.game.api.score.ScoreBadge;
import com.bgpark.game.api.score.ScoreBadgeRepository;
import com.bgpark.game.api.score.ScoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class ScoreServiceImplTest {

    private ScoreServiceImpl scoreService;

    @Mock private ScoreRepository scoreRepository;
    @Mock private ScoreBadgeRepository scoreBadgeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        scoreService = new ScoreServiceImpl(scoreRepository, scoreBadgeRepository);
    }

    @Test
    void calculateCorrectTrue() {

        String username = "bgpark";
        Long resultId = 1L;
        boolean correct = true;

        Score score = new Score(username, resultId);
        given(scoreRepository.save(any())).willReturn(score);

        Score newScore = scoreService.calculate(username, resultId, correct);
        assertThat(newScore.getResultId()).isEqualTo(1L);
        assertThat(newScore.getScore()).isEqualTo(10);
        assertThat(newScore.getUsername()).isEqualTo("bgpark");
    }

    @Test
    void calculateCorrectFalse() {

        String username = "bgpark";
        Long resultId = 1L;
        boolean correct = false;

        Score score = new Score(username, resultId);
        given(scoreRepository.save(any())).willReturn(score);

        Score newScore = scoreService.calculate(username, resultId, correct);
        System.out.println(newScore);

        assertThat(newScore.getResultId()).isEqualTo(null);
        assertThat(newScore.getScore()).isEqualTo(0);
        assertThat(newScore.getUsername()).isEqualTo(null);
    }

    @Test
    void calculateTotalScore() {

        String username = "bgpark";
        Long resultId = 1L;
        boolean correct = true;

        Score score = new Score(username, resultId);
        given(scoreRepository.save(any())).willReturn(score);

        int totalScore = scoreRepository.getTotalScoreByUsername(username);
        ScoreBadge scoreBadge = new ScoreBadge(totalScore, username);
        given(scoreBadgeRepository.save(any())).willReturn(scoreBadge);

        Score newScore = scoreService.calculate(username, resultId, correct);

        assertThat(newScore.getResultId()).isEqualTo(1L);
        assertThat(newScore.getScore()).isEqualTo(10);
        assertThat(newScore.getUsername()).isEqualTo("bgpark");

        verify(scoreBadgeRepository).save(any());
    }

    @Test
    void calculateTotalScoreNull() {

        String username = "bgpark";
        Long resultId = 1L;
        boolean correct = true;

        Score score = new Score(username, resultId);
        given(scoreRepository.save(any())).willReturn(score);

        int totalScore = scoreRepository.getTotalScoreByUsername(username);
        ScoreBadge scoreBadge = new ScoreBadge(totalScore, username);
        given(scoreBadgeRepository.save(any())).willReturn(scoreBadge);

        Score newScore = scoreService.calculate(username, resultId, correct);

        assertThat(newScore.getResultId()).isEqualTo(1L);
        assertThat(newScore.getScore()).isEqualTo(10);
        assertThat(newScore.getUsername()).isEqualTo("bgpark");

        verify(scoreBadgeRepository).save(any());
    }
}