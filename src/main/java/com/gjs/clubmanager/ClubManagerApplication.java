package com.gjs.clubmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(basePackages = "com.gjs.mapper")
@SpringBootApplication(scanBasePackages = "com.gjs")
@ServletComponentScan
public class ClubManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubManagerApplication.class, args);
    }

}
