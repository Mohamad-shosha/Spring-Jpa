package com.shosha.springboot.demo.error.exception;

import com.shosha.springboot.demo.util.time.CurrentTimeStamp;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;

@Value
@EqualsAndHashCode(callSuper = true)
public class InstructorNotFoundException extends RuntimeException {
    Integer code = 657;
    String message = "Instructor not found";
    String description;
    Timestamp timestamp;

    public InstructorNotFoundException(String message) {
        this.description = message;
        this.timestamp = CurrentTimeStamp.timestamp();
    }
}
