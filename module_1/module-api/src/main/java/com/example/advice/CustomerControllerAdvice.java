package com.example.advice;

import com.example.controller.CustomerController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * CustomerControllerAdvice.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.27
 */
@RestControllerAdvice(basePackageClasses = CustomerController.class)
public class CustomerControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity error(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

}
