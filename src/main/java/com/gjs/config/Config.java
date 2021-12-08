package com.gjs.config;

import com.gjs.interceptor.AuthorityInterceptor;
import com.gjs.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 配置跨域访问
@SpringBootConfiguration
public class Config  implements WebMvcConfigurer {



    LogInterceptor logInterceptor;

    AuthorityInterceptor authorityInterceptor;

    @Autowired
    public Config(LogInterceptor logInterceptor, AuthorityInterceptor authorityInterceptor) {
        this.logInterceptor = logInterceptor;
        this.authorityInterceptor = authorityInterceptor;
    }




    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加映射路径
        registry.addMapping("/**")
                // 是否发送Cookie
                .allowCredentials(true)
                // 设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")
                .allowedOriginPatterns("*")
                // 放行哪些请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // .allowedMethods("*") //或者放行全部
                //放行哪些原始请求头部信息
                .allowedHeaders("*")
                // 暴露哪些原始请求头部信息
                .exposedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册日志拦截器
        registry.addInterceptor(logInterceptor).
                addPathPatterns("/**");


        // 注册权限控制器
        registry.addInterceptor(authorityInterceptor).
                excludePathPatterns("/user/login","/user/register").
                excludePathPatterns("/*.html","/css/*.css","/js/*.js","*.map").
                excludePathPatterns("/grade/*","/error").
                addPathPatterns("/**");

        //WebMvcConfigurer.super.addInterceptors(registry);
    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.
//                addResourceHandler("/static/*").
//                addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
//
//        // WebMvcConfigurer.super.addResourceHandlers(registry);
//    }
}
