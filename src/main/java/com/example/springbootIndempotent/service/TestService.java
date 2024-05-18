package com.example.springbootIndempotent.service;

import com.example.springbootIndempotent.common.Response;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-19 03:29
 */
public interface TestService {
    public String testIdempotence();
}
