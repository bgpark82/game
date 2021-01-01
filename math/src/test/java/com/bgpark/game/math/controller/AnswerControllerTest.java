package com.bgpark.game.math.controller;

import com.bgpark.game.api.math.Answer;
import com.bgpark.game.api.math.AnswerService;
import com.bgpark.game.api.math.Math;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mapper = new ObjectMapper();
    }

    @Test
    void getAnswer() throws Exception {

        Answer answer = new Answer(150, new Math(10, 15), "bgpark");
        String answerString = mapper.writeValueAsString(answer);

        mvc.perform(post("/math/answer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(answerString))
                .andExpect(status().isOk());
    }

    @Test
    void getAnswerId() throws Exception {

        Answer answer = new Answer(150, new Math(10, 15), "bgpark");
        String answerString = mapper.writeValueAsString(answer);

        given(answerService.getAnswer(any())).willReturn(answer);

        mvc.perform(post("/math/answer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(answerString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.answer").value(150))
                .andExpect(jsonPath("$.data.username").value("bgpark"));
    }

    @Test
    void getAnswerTrue() throws Exception {

        Answer answer = new Answer(150, new Math(10, 15), "bgpark");
        answer.isCorrect(150);
        String answerString = mapper.writeValueAsString(answer);

        given(answerService.getAnswer(any())).willReturn(answer);

        mvc.perform(post("/math/answer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(answerString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.answer").value(150))
                .andExpect(jsonPath("$.data.username").value("bgpark"))
                .andExpect(jsonPath("$.data.correct").value(true));
    }
}