package com.shosha.springboot.demo.util.time;

import java.sql.Timestamp;

public class CurrentTimeStamp {

    private CurrentTimeStamp() {

    }

    public static Timestamp timestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
