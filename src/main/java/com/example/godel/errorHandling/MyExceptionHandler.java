package com.example.godel.errorHandling;

import com.example.godel.controllers.EmployeeController;
import com.example.godel.exception.EmployeeServiceException;
import com.example.godel.exception.EmployeeServiceNotFoundException;
import com.example.godel.exception.ExceptionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class MyExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ExceptionInfo> handleValidationId(ConstraintViolationException e){
        ExceptionInfo exInfo= new ExceptionInfo()
                .setError("validation ex-0006")
                .setMessage("incorrect id")
                .setDetail("might be >=1")
                .setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
        logger.error(String.valueOf(e));
        return new ResponseEntity<>(exInfo,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeServiceNotFoundException.class)
    protected ResponseEntity<ExceptionInfo> handleNotFound(EmployeeServiceNotFoundException e){
     ExceptionInfo exInfo= new ExceptionInfo()
                .setError("not found-0001")
                .setMessage("Incorrect id")
                .setDetail("Ensure that the id included in the request is correct")
                .setHttpStatus(HttpStatus.NOT_FOUND);
        logger.error(String.valueOf(e));

        return new ResponseEntity<>(exInfo,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeServiceException.class)
    protected ResponseEntity<ExceptionInfo> handleException(EmployeeServiceException e){
        ExceptionInfo exInfo=new ExceptionInfo()
                .setError("invalid data-0002")
                .setMessage("invalid data")
                .setDetail("Ensure that the data in the body of request is correct")
                .setHttpStatus(HttpStatus.BAD_REQUEST);
        logger.error(String.valueOf(e));
        return new ResponseEntity<>(exInfo,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionInfo> handleValidationEx(MethodArgumentNotValidException e){
        ExceptionInfo exInfo= new ExceptionInfo()
                .setError("validation ex-0004")
                .setMessage("incorrect date of birth")
                .setDetail("might be > 18 years")
                .setHttpStatus(HttpStatus.NOT_ACCEPTABLE);
        logger.error(String.valueOf(e));
        return new ResponseEntity<>(exInfo,HttpStatus.BAD_REQUEST);
    }
        @ExceptionHandler(Throwable.class)
    protected  ResponseEntity<ExceptionInfo> handleThrowable(Throwable t){
        ExceptionInfo exInfo= new ExceptionInfo()
                .setError("something gonna wrong-0003")
                .setMessage("try later")
                .setDetail("")
                .setHttpStatus(HttpStatus.BAD_REQUEST);
        logger.error(String.valueOf(t));
        return new ResponseEntity<>(exInfo,HttpStatus.BAD_REQUEST);
    }

}
