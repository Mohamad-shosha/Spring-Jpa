package com.shosha.springboot.demo.util.time;

import java.sql.Timestamp;

/**
 * Utility class for generating the current timestamp.
 */
public class CurrentTimeStamp {

    private CurrentTimeStamp() {

    }

    public static Timestamp timestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
