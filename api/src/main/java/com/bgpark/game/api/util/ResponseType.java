package com.bgpark.game.api.util;

import java.time.LocalDateTime;

public class ResponseType<T> implements Response<T>{

    private LocalDateTime timestamp;
    private int status;
    private T data;
    private String network;

    public ResponseType(int status, T data, String network) {

        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.data = data;
        this.network = network;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getNetwork() {
        return network;
    }
}
