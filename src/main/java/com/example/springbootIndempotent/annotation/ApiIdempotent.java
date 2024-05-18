package com.example.springbootIndempotent.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description 在需要保证 接口幂等性 的Controller的方法上使用此注解
 * @date 2024-05-18 11:52
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {
}
