package com.bgpark.game.api.math;

import lombok.*;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Answer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int answer;

    @Embedded
    private Math math;
    private String username;
    private boolean correct;

    @Builder
    public Answer(int answer, Math math, String username) {
        this.answer = answer;
        this.math = math;
        this.username = username;
    }

    public void setCorrect() {
        correct = answer == math.getFactorA() * math.getFactorB();
    }


}
