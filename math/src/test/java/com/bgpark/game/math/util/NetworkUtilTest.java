package com.bgpark.game.math.util;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

class NetworkUtilTest {

    @Test
    void iNetAddressTest() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        System.out.println(hostName);
        System.out.println(hostAddress);
    }
}