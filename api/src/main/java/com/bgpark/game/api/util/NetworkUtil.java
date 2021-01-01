package com.bgpark.game.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class NetworkUtil {

    private final String port;

    public NetworkUtil(@Value("${server.port}") String port) {
        this.port = port;
    }

    public String getAddress() {
        return getLocalHostName() + "/" + getLocalIpAddress() + ":" + port;
    }

    private String getLocalHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unknown hostname";
        }
    }

    private String getLocalIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "Unknown hostname";
        }
    }
}
