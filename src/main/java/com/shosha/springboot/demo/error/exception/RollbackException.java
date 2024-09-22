package com.shosha.springboot.demo.error.exception;

import com.shosha.springboot.demo.util.time.CurrentTimeStamp;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.SQLException;
import java.sql.Timestamp;

@Getter
@EqualsAndHashCode(callSuper = true)
public class RollbackException extends SQLException {
    Integer code = 455;
    String message = "liquibase Exception";
    String description ;
    Timestamp timestamp ;

    public RollbackException(String description) {
        this.description = description;
        timestamp = CurrentTimeStamp.timestamp();
    }
}
