package com.bgpark.game.api.score;

import java.util.List;

public interface ScoreService {

    Score calculate(String username, Long resultId, boolean correct);

    List<Score> getScores();
}
