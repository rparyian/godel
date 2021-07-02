package com.example.godel.errorHandling;

import com.example.godel.exception.EmployeeServiceException;
import com.example.godel.exception.EmployeeServiceNotFoundException;
import com.example.godel.exception.ExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(EmployeeServiceNotFoundException.class)
    protected ResponseEntity<ExceptionInfo> handleNotFound(EmployeeServiceNotFoundException e){
     ExceptionInfo exInfo= new ExceptionInfo()
                .setError("not found-0001")
                .setMessage("Incorrect id")
                .setDetail("Ensure that the id included in the request is correct")
                .setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exInfo,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeServiceException.class)
    protected ResponseEntity<ExceptionInfo> handleException(EmployeeServiceException e){
        ExceptionInfo exInfo=new ExceptionInfo()
                .setError("invalid data-0002")
                .setMessage("invalid data")
                .setDetail("Ensure that the data in the body of request is correct")
                .setHttpStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exInfo,HttpStatus.BAD_REQUEST);
    }

}
