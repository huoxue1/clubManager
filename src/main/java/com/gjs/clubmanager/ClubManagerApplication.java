package com.gjs.clubmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan(basePackages = "com.gjs.dao")
@SpringBootApplication(scanBasePackages = "com.gjs")
@ServletComponentScan
public class ClubManagerApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ClubManagerApplication.class, args);
    }
}
