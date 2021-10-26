package com.gjs.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Slf4j
@Order(1)
@WebFilter(filterName = "security",urlPatterns = "/")
public class Filter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        javax.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("我拦截了客户端的请求");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(true);
        if (session.isNew()){
            log.info("创建了session");
        }
        session.setAttribute("login",123);
        filterChain.doFilter(servletRequest,servletResponse);
        
        log.info("我拦截到了客户端的响应");
    }

    @Override
    public void destroy() {
        javax.servlet.Filter.super.destroy();
    }
}
