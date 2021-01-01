package com.bgpark.game.api.math.dto;

import com.bgpark.game.api.math.Answer;
import com.bgpark.game.api.math.Math;
import lombok.Data;

public class AnswerDto {

    @Data
    public static class Create {

        private int answer;
        private String username;
        private int factorA;
        private int factorB;

        public Answer toEntity() {
            return Answer.builder()
                    .answer(answer)
                    .math(new Math(factorA, factorB))
                    .username(username)
                    .build();
        }
    }
}
