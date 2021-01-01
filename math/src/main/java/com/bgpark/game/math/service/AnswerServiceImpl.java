package com.bgpark.game.math.service;

import com.bgpark.game.api.math.Answer;
import com.bgpark.game.api.math.AnswerRepository;
import com.bgpark.game.api.math.AnswerService;
import com.bgpark.game.api.math.dto.AnswerDto;
import com.bgpark.game.math.util.CalculatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final CalculatorUtil calculatorUtil;
    private final AnswerRepository answerRepository;

    @Override
    public Answer getAnswer(AnswerDto.Create request) {

        int factorA = request.getFactorA();
        int factorB = request.getFactorB();
        int result = calculatorUtil.multiplication(factorA, factorB);

        Answer entity = request.toEntity();
        entity.isCorrect(result);

        Answer savedAnswer = answerRepository.save(entity);

        return savedAnswer;
    }
}
