package com.gjs.anotion;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface  Auth{
    String grade() default "public";
}

