package com.example.machine_translaton_service.exception;

import io.micrometer.common.lang.Nullable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandleController extends ResponseEntityExceptionHandler {

    @Nullable
    private MessageSource messageSource;

    @ExceptionHandler(value
            = {CustomException.class})
    protected ResponseEntity<Object> handleConflict(
            CustomException ex, WebRequest request) {
        ProblemDetail body = this.createProblemDetail(ex, ex.getHttpStatus(), ex.getMessage(),
                (String) null, (Object[]) null, request);
        return handleExceptionInternal(ex, body,
                new HttpHeaders(), ex.getHttpStatus(), request);
    }

    @ExceptionHandler(value
            = {Exception.class})
    protected ResponseEntity<Object> handleExceptionFallback(
            Exception ex, WebRequest request) {
        ProblemDetail body = this.createProblemDetail(ex, HttpStatus.BAD_REQUEST, ex.getMessage(),
                (String) null, (Object[]) null, request);
        return handleExceptionInternal(ex, body,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String bodyOfResponse = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        ProblemDetail body = this.createProblemDetail(ex, HttpStatus.BAD_REQUEST, bodyOfResponse,
                (String) null, null, request);
        return handleExceptionInternal(ex, body,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    public ProblemDetail createProblemDetail(Exception ex, HttpStatus status, String detail, @Nullable String title, @Nullable Object[] args, WebRequest request) {
        ErrorResponse.Builder builder = ErrorResponse.builder(ex, status, detail);
        if (title != null) {
            builder.detailMessageCode(title);
        }
        if (args != null) {
            builder.detailMessageArguments(args);
        }
        return builder.build().updateAndGetBody(this.messageSource, LocaleContextHolder.getLocale());
    }

}
