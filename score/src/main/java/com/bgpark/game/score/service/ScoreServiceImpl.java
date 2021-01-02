package com.bgpark.game.score.service;

import com.bgpark.game.api.score.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AopInvocationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    private final ScoreBadgeRepository scoreBadgeRepository;

    @Override
    public Score calculate(String username, Long resultId, boolean correct) {
        if(correct) {

            Score score = new Score(username, resultId);
            scoreRepository.save(score);

            int totalScore = scoreRepository.getTotalScoreByUsername(username);

            ScoreBadge scoreBadge = new ScoreBadge(totalScore, username);
            scoreBadgeRepository.save(scoreBadge);

            return score;
        }
        return new Score();
    }

    @Override
    public List<Score> getScores() {
        return scoreRepository.findAll();
    }
}
