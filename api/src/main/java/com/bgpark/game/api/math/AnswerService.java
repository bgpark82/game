package com.bgpark.game.api.math;

import com.bgpark.game.api.math.dto.AnswerDto;

public interface AnswerService {

    Answer getAnswer(AnswerDto.Create request);
}
