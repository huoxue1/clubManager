package com.gjs.interceptor;

import com.gjs.dao.UserDao;
import com.gjs.entity.User;
import com.gjs.exception.exceptionImpl.CustomException;
import com.gjs.utils.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
@Component
public class AuthorityInterceptor implements HandlerInterceptor {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (Objects.equals(request.getMethod(), "OPTIONS")){
            return true;
        }

        log.debug("经过鉴权"+request.getRequestURI());
        // 获取session
        String token;
        try {
            System.out.println(request.getHeader("Authorization"));
            token = request.getHeader("Authorization").split(" ")[1];
        }catch (ArrayIndexOutOfBoundsException ignored){
            throw new CustomException(1403,"访问权限不足");
        }

        Integer userId = Token.decode(token);
        User user = userDao.queryById(userId);
        if (user == null) {
            throw new CustomException(1403,"访问权限不足");
        }
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
