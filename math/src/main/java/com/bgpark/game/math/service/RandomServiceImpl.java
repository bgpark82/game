package com.bgpark.game.math.service;

import com.bgpark.game.api.math.RandomService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomServiceImpl implements RandomService {

    private static final int MAX_NUMBER = 10;
    private static final int MIN_NUMBER = 1;

    @Override
    public int generateNumber() {
        return new Random().nextInt((MAX_NUMBER - MIN_NUMBER + 1))  + MIN_NUMBER;
    }
}
