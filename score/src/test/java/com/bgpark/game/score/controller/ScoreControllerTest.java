package com.bgpark.game.score.controller;

import com.bgpark.game.api.score.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ScoreController.class)
class ScoreControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ScoreService scoreService;

    @MockBean
    private ScoreBadgeService scoreBadgeService;

    private JacksonTester<ScoreDto.Req> jsonScore;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void getResultOk() throws Exception {

        ScoreDto.Req score = new ScoreDto.Req("bgpark", 1L, true);
        String request = jsonScore.write(score).getJson();

        mvc.perform(post("/score/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk());
    }

    @Test
    void getResult() throws Exception {

        ScoreDto.Req score = new ScoreDto.Req("bgpark", 1L, true);
        String request = jsonScore.write(score).getJson();
        Score savedScore = new Score(1L,"bgpark", 1L, 10);

        given(scoreService.calculate("bgpark", 1L, true)).willReturn(savedScore);

        mvc.perform(post("/score/result")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.score").value(10));
    }

    @Test
    void getTotalOk() throws Exception {

        String username = "bgpark";

        mvc.perform(get("/score/total?username="+username))
                .andExpect(status().isOk());
    }

    @Test
    void getTotalReturnTotalScore() throws Exception {

        String username = "bgpark";

        given(scoreBadgeService.getTotalScore(username)).willReturn(new ScoreBadge( 300, username));

        mvc.perform(get("/score/total?username=" + username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.totalScore").exists());

        verify(scoreBadgeService).getTotalScore(username);
    }


    @Test
    void getTotalReturnTotalScoreNull() throws Exception {

        String username = "bgpark";

        given(scoreBadgeService.getTotalScore(username)).willReturn(null);

        mvc.perform(get("/score/total?username=" + username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.totalScore").value(0));

        verify(scoreBadgeService).getTotalScore(username);
    }
}