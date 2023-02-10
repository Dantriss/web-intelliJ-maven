package com.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String handleException(IllegalArgumentException exception) {

        return "<h1>" + exception.getMessage()+"</h1>";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException2(Exception exception) {

        return "<h1>" + exception.getMessage()+"</h1>";
    }

}
