package com.medibuddy.doctorAppointment.exceptions;

import com.medibuddy.doctorAppointment.paylods.ApiResponse;
import com.medibuddy.doctorAppointment.utils.JsonMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse<String>> resourceNotFoundHandler(ResourceNotFound e){
        return new ResponseEntity<>(
                new ApiResponse<>(JsonMessage.FAIL,e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        Map<String,String> map = new HashMap<>();
        map.put("message", String.valueOf(JsonMessage.FAIL));
        map.put("data", String.valueOf(e.getFieldError()));
        return new ResponseEntity<>(
                map,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> exceptionHandler(Exception e){
        return new ResponseEntity<>(
                new ApiResponse<>(JsonMessage.FAIL,e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
