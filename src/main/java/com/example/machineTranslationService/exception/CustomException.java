package com.example.machineTranslationService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private final String message;
    private final HttpStatus httpStatus;
}
