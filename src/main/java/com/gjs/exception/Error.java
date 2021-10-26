package com.gjs.exception;


import com.gjs.entity.H;
import com.gjs.exception.exceptionImpl.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class Error {


    @ExceptionHandler(value = NullPointerException.class)
    public H exceptionHandle(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常:",e);
        return H.error(CommonEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(value = CustomException.class)
    public H exceptionHandle(HttpServletRequest req, CustomException e){
        log.error("发生业务异常:{}",e.getErrorMsg());
        return H.error(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public H exceptionHandle(HttpServletRequest req,Exception e){

        log.error("发生未知异常：",e);
        return H.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }

}
