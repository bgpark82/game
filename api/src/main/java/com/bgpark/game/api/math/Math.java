package com.bgpark.game.api.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor
@Embeddable
public class Math {

    private final int factorA;
    private final int factorB;

    public Math() {
        this(0,0);
    }
}
