package com.example.springbootIndempotent.service;

import com.example.springbootIndempotent.common.Response;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-18 11:53
 */
public interface TokenService {
    /**
     * 创建token
     * @return
     */
    public String createToken();

    /**
     * 检验token
     * @param request
     * @return
     */
    public boolean checkToken(HttpServletRequest request) throws Exception;
}
