package com.bgpark.game.api.score;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ScoreDto {

    @Data
    @NoArgsConstructor
    public static class Req {

        private String username;
        private Long resultId;
        private boolean correct;

        public Req(String username, Long resultId, boolean correct) {
            this.username = username;
            this.resultId = resultId;
            this.correct = correct;
        }
    }
}
