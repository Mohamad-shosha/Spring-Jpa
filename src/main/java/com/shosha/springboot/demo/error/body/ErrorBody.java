package com.shosha.springboot.demo.error.body;


import java.sql.Timestamp;

public record ErrorBody(Integer code, String message, String detail , Timestamp timestamp) {

}
