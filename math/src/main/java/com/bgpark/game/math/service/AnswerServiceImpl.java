package com.bgpark.game.math.service;

import com.bgpark.game.api.math.Answer;
import com.bgpark.game.api.math.AnswerRepository;
import com.bgpark.game.api.math.AnswerService;
import com.bgpark.game.math.event.AnswerApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerApi answerApi;
    private final AnswerRepository answerRepository;

    @Override
    public boolean getAnswer(Answer answer) {

        answer.setCorrect();
        Answer savedAnswer = answerRepository.save(answer);

        try {
            answerApi.sendScore(savedAnswer.getUsername(), savedAnswer.getId(), savedAnswer.isCorrect());
        } catch (HttpClientErrorException ex) {
            switch(ex.getStatusCode()) {
                case NOT_FOUND:
                    log.debug("Fail to send score to server: Not Found");
                    throw new RuntimeException("Not Found!");
            }
        }

        return answer.isCorrect();
    }
}
