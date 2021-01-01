package com.bgpark.game.math.controller;

import com.bgpark.game.api.math.Answer;
import com.bgpark.game.api.math.AnswerService;
import com.bgpark.game.api.math.dto.AnswerDto;
import com.bgpark.game.api.util.NetworkUtil;
import com.bgpark.game.api.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final NetworkUtil networkUtil;

    @PostMapping("/math/answer")
    public Response<Answer> getAnswer(@RequestBody AnswerDto.Create request) {
        log.debug("Answer from the client: {}", request);

        Answer answer = answerService.getAnswer(request);
        String address = networkUtil.getAddress();
        return Response.ok(answer, address);
    }
}

