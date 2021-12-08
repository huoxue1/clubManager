package com.gjs.exception;


import com.gjs.exception.exceptionImpl.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class Error {


    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<Exception> exceptionHandle(HttpServletRequest req, HttpServletResponse response,NullPointerException e){
        log.error("发生空指针异常:",e);
        response.setStatus(401);
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Exception> exceptionHandle(HttpServletRequest req, HttpServletResponse response,CustomException e){
        log.error("发生业务异常:{}",e.getErrorMsg());
        response.setStatus(401);
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Exception> exceptionHandle(HttpServletRequest req,HttpServletResponse response,Exception e){

        log.error("发生未知异常：",e);
        response.setStatus(401);
        return ResponseEntity.badRequest().body(e);
    }

}
