package com.banking.siigroup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		MessageResponse error = new MessageResponse();
        StringBuilder builder = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((err) -> {
            builder.append(" | "+err.getDefaultMessage());
        });
        error.setMessage(builder.toString());    
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);



    }
	
}
