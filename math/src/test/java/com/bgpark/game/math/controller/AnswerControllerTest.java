package com.bgpark.game.math.controller;

import com.bgpark.game.api.math.Answer;
import com.bgpark.game.api.math.AnswerDto;
import com.bgpark.game.api.math.AnswerService;
import com.bgpark.game.api.math.Math;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AnswerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnswerService answerService;

    private JacksonTester<AnswerDto.Create> jacksonCreate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void getAnswer() throws Exception {

        AnswerDto.Create answerDto = new AnswerDto.Create(150, "bgpark", 10, 15);
        String request = jacksonCreate.write(answerDto).getJson();

        mvc.perform(post("/math/answer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk());
    }

    @Test
    void getAnswerFalse() throws Exception {

        AnswerDto.Create answerDto = new AnswerDto.Create(150, "bgpark", 10, 100);
        String request = jacksonCreate.write(answerDto).getJson();

        given(answerService.getAnswer(any())).willReturn(false);

        mvc.perform(post("/math/answer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(false));
    }

    @Test
    void getAnswerTrue() throws Exception {

        AnswerDto.Create answerDto = new AnswerDto.Create(150, "bgpark", 10, 15);
        String request = jacksonCreate.write(answerDto).getJson();

        given(answerService.getAnswer(any())).willReturn(true);

        mvc.perform(post("/math/answer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(true));
    }
}