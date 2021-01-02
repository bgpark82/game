package com.bgpark.game.math.service;

import com.bgpark.game.api.math.Math;
import com.bgpark.game.api.math.MathService;
import com.bgpark.game.api.math.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MathServiceImpl implements MathService {

    private final RandomService randomService;

    @Override
    public Math createMath() {
        int factorA = randomService.generateNumber();
        int factorB = randomService.generateNumber();

        return new Math(factorA, factorB);
    }
}
