package com.codevalue.rest.exception;

import java.time.ZoneId;
import java.util.Date;
import com.codevalue.restserver.dto.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setTimestamp( new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        errorModel.setMessage(ex.getMessage());
        errorModel.setDetails(request.getDescription(false));
        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExcpetionHandler(Exception ex, WebRequest request) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setTimestamp( new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        errorModel.setMessage(ex.getMessage());
        errorModel.setDetails(request.getDescription(false));
        return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
