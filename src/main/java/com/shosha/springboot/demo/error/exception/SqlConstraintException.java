package com.shosha.springboot.demo.error.exception;

import com.shosha.springboot.demo.util.time.CurrentTimeStamp;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;

@Value
@EqualsAndHashCode(callSuper = true)
public class SqlConstraintException extends SQLIntegrityConstraintViolationException {
    Integer code = 967;
    String errorMassage = "SQL Exception";
    String description;
    Timestamp timestamp;

    public SqlConstraintException(String message) {
        this.description = message;
        this.timestamp = CurrentTimeStamp.timestamp();
    }

}
