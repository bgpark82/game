package com.bgpark.game.math.event;

import com.bgpark.game.api.score.ScoreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnswerApi {

    private final RestTemplate restTemplate;

    public void sendScore(String username, Long resultId, boolean correct) {
        ScoreDto.Req score = new ScoreDto.Req(username, resultId, correct);
        ScoreDto.Req req = restTemplate.postForObject("http://localhost:7002/score/result", score, ScoreDto.Req.class);
        log.debug("Score request to score server: {}", req);
    }

}
