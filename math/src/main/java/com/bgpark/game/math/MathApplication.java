package com.bgpark.game.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bgpark.game")
public class MathApplication {

    public static void main(String[] args) {
        SpringApplication.run(MathApplication.class, args);
    }

}
