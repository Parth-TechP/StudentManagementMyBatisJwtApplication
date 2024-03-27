package com.parth.StudentManagementMyBatisJwt.config;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface JwtUserConnMapper {
    String value() default "";
}
