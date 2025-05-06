package com.example.pet_tracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * Global exception handler for the entire application.
 * Handles specific and generic exceptions and returns appropriate HTTP responses.
 */

@ControllerAdvice
public class GlobalExceptionHandler {

      /**
     * Handles IllegalArgumentExceptions thrown from any controller or service.
     *
     * @param ex the exception thrown
     * @return a 400 Bad Request response with the exception message
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles any unhandled or general exceptions across the app.
     *
     * @param ex the exception thrown
     * @return a 500 Internal Server Error with a generic error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneral(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Something went wrong: " + ex.getClass().getSimpleName());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
