package com.shosha.springboot.demo.error;

import com.shosha.springboot.demo.error.body.ErrorBody;
import com.shosha.springboot.demo.error.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler is a controller advice class that handles various exceptions
 * thrown within the application and converts them into standardized HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles SQL constraint violations by converting the SqlConstraintException to a well-defined error response.
     *
     * @param sqlConstraintException the exception that indicates a SQL constraint violation
     * @return a ResponseEntity containing an ErrorBody with details of the exception and a conflict (409) HTTP status
     */
    @ExceptionHandler(SqlConstraintException.class)
    public ResponseEntity<ErrorBody> handleSqlConstraintException(SqlConstraintException sqlConstraintException) {
        ErrorBody errorBody = new ErrorBody(sqlConstraintException.getCode(),
                sqlConstraintException.getErrorMassage(),
                sqlConstraintException.getDescription(),
                sqlConstraintException.getTimestamp());
        return new ResponseEntity<>(errorBody, HttpStatus.CONFLICT);
    }


    /**
     * Handles the InstructorNotFoundException by converting it to a well-defined error response.
     *
     * @param instructorNotFoundException the exception that indicates the instructor was not found
     * @return a ResponseEntity containing an ErrorBody with details of the exception and a not found (404) HTTP status
     */
    @ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<ErrorBody> handleInstructorNotFoundException(InstructorNotFoundException instructorNotFoundException) {
        ErrorBody errorBody = new ErrorBody(instructorNotFoundException.getCode(),
                instructorNotFoundException.getMessage(),
                instructorNotFoundException.getDescription(),
                instructorNotFoundException.getTimestamp()
                );
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the RollbackException by converting it to a well-defined error response.
     *
     * @param rollbackException the exception that indicates a rollback occurred
     * @return a ResponseEntity containing an ErrorBody with details of the exception and an internal server error (500) HTTP status
     */
    @ExceptionHandler({RollbackException.class})
    public ResponseEntity<ErrorBody> handleRollbackException(RollbackException rollbackException) {
        ErrorBody errorBody = new ErrorBody(rollbackException.getCode(),
                rollbackException.getMessage(),
                rollbackException.getDescription(),
                rollbackException.getTimestamp());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
