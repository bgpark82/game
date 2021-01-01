package com.bgpark.game.math.controller;

import com.bgpark.game.api.math.Math;
import com.bgpark.game.api.math.MathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MathService mathService;

    @Test
    void createMath() throws Exception {
        mvc.perform(get("/math/generate")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createMathRandomFactors() throws Exception {
        given(mathService.createMath()).willReturn(new Math(10, 15));

        mvc.perform(get("/math/generate")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.factorA").value(10))
                .andExpect(jsonPath("$.data.factorB").value(15));
    }
}