package com.pricing.presentation.handleExceptions;


import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Handle exceptions
 * 
 * @author beatr
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Handle exceptions
	 * 
	 * @param ex exception
	 * @param request web request
	 * 
	 * @return response entity with the error message
	 */
    @ExceptionHandler(value = { IllegalArgumentException.class, ConstraintViolationException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), 
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}