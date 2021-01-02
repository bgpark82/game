package com.bgpark.game.score.service;

import com.bgpark.game.api.score.ScoreBadge;
import com.bgpark.game.api.score.ScoreBadgeRepository;
import com.bgpark.game.api.score.ScoreBadgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreBadgeServiceImpl implements ScoreBadgeService {

    private final ScoreBadgeRepository scoreBadgeRepository;

    @Override
    public ScoreBadge getTotalScore(String username) {
        return scoreBadgeRepository.findFirstByUsernameOrderByTimestampDesc(username);
    }
}
