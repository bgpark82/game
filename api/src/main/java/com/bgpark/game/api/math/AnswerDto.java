package com.bgpark.game.api.math;

import lombok.AllArgsConstructor;
import lombok.Data;

public class AnswerDto {

    @Data
    @AllArgsConstructor
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
