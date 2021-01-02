package com.bgpark.game.score.controller;

import com.bgpark.game.api.score.*;
import com.bgpark.game.api.util.NetworkUtil;
import com.bgpark.game.api.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;
    private final ScoreBadgeService scoreBadgeService;
    private final NetworkUtil networkUtil;

    @PostMapping("/result")
    public Response<Score> getScore(@RequestBody ScoreDto.Req score) {
        log.debug("Score from the math server: {}", score);

        String address = networkUtil.getAddress();
        Score savedScore = scoreService.calculate(score.getUsername(), score.getResultId(), score.isCorrect());
        return Response.ok(savedScore, address);
    }

    @GetMapping("/results")
    public Response<List<Score>> getScores() {
        String address = networkUtil.getAddress();
        return Response.ok(scoreService.getScores(), address);
    }

    @GetMapping("/total")
    public Response<ScoreBadge> getTotal(@RequestParam String username) {
        ScoreBadge totalScore = scoreBadgeService.getTotalScore(username);
        log.debug("total score from db: {}", totalScore);

        if(totalScore == null) {
            totalScore = new ScoreBadge(0, username);
        }

        String address = networkUtil.getAddress();
        return Response.ok(totalScore, address);
    }

}
