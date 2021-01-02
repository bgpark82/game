package com.bgpark.game.api.score;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ScoreBadgeRepositoryTest {

    @Autowired
    private ScoreBadgeRepository scoreBadgeRepository;

    @Test
    void findTopTotal() {
        String username = "bgpark";

        List<ScoreBadge> scoreBadges = Arrays.asList(
                new ScoreBadge(null, 50, username, LocalDateTime.now().minusMinutes(4)),
                new ScoreBadge(null, 100, username, LocalDateTime.now().minusMinutes(3)),
                new ScoreBadge(null, 200, username, LocalDateTime.now().minusMinutes(2)),
                new ScoreBadge(null, 300, username, LocalDateTime.now().minusMinutes(1))
        );

        scoreBadgeRepository.saveAll(scoreBadges);

        Page<ScoreBadge> topScore = scoreBadgeRepository.findTopScore(username, PageRequest.of(0, 1));
        System.out.println(topScore);
        assertThat(topScore.getContent().get(0).getTotalScore()).isEqualTo(300);
    }

    @Test
    void findFirstByUsernameOrderByTimestampDesc() {
        String username = "bgpark";

        List<ScoreBadge> scoreBadges = Arrays.asList(
                new ScoreBadge(null, 50, username, LocalDateTime.now().minusMinutes(4)),
                new ScoreBadge(null, 100, username, LocalDateTime.now().minusMinutes(3)),
                new ScoreBadge(null, 200, username, LocalDateTime.now().minusMinutes(2)),
                new ScoreBadge(null, 300, username, LocalDateTime.now().minusMinutes(1))
        );

        scoreBadgeRepository.saveAll(scoreBadges);

        ScoreBadge topScore = scoreBadgeRepository.findFirstByUsernameOrderByTimestampDesc(username);
        assertThat(topScore.getTotalScore()).isEqualTo(300);
    }
}