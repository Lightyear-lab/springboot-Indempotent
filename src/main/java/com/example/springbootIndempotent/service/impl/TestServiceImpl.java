package com.example.springbootIndempotent.service.impl;

import com.example.springbootIndempotent.common.Response;
import com.example.springbootIndempotent.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-19 03:31
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testIdempotence() {
        return "test idempotent success";
    }
}
