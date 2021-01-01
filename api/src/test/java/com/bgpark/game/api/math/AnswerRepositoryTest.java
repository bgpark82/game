package com.bgpark.game.api.math;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository repository;

    @Test
    void saveAnswer() {
        Answer answer = new Answer(150, new Math(10, 15), "bgpark");

        Answer save = repository.save(answer);

        assertThat(save.getId()).isEqualTo(1L);
        assertThat(save.getAnswer()).isEqualTo(150);
        assertThat(save.getMath().getFactorA()).isEqualTo(10);
        assertThat(save.getMath().getFactorB()).isEqualTo(15);
        assertThat(save.getUsername()).isEqualTo("bgpark");
    }
}