package com.bgpark.game.api.util;

import com.bgpark.game.api.score.Score;

import java.time.LocalDateTime;
import java.util.List;

public interface Response<T> {

    int getStatus();
    T getData();
    String getNetwork();
    LocalDateTime getTimestamp();

    static <T> Response<T> ok(T data, String network) {
        return new ResponseType(200, data, network);
    }

}
