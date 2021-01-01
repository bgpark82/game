package com.bgpark.game.math.controller;

import com.bgpark.game.api.math.Math;
import com.bgpark.game.api.math.MathService;
import com.bgpark.game.api.util.NetworkUtil;
import com.bgpark.game.api.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;
    private final NetworkUtil networkUtil;

    @GetMapping("/math/generate")
    public Response<Math> createMath() {
        Math math = mathService.createMath();
        String address = networkUtil.getAddress();
        return Response.ok(math, address);
    }
}
