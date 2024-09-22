package com.shosha.springboot.demo.util.randomids;

import java.util.UUID;

public class RandomValues {

    private RandomValues() {

    }

    public static String randomNumbersForId() {
        return UUID.randomUUID().toString();
    }
}
