package com.example.springbootIndempotent.controller;

import cn.hutool.core.util.StrUtil;
import com.example.springbootIndempotent.annotation.ApiIdempotent;
import com.example.springbootIndempotent.common.Response;
import com.example.springbootIndempotent.common.ResponseCode;
import com.example.springbootIndempotent.service.TestService;
import com.example.springbootIndempotent.service.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-19 01:44
 */
@RestController
public class BusinessController {
    @Resource
    private TokenService tokenService;
    @Resource
    private TestService testService;


    @PostMapping("/get/token")
    public Response getToken(){
        String tokenValue = tokenService.createToken();
        if (StrUtil.isNotEmpty(tokenValue)) {
            Response responseVo = new Response();
            responseVo.setStatus(ResponseCode.SUCCESS_TOKEN.getCode());
            responseVo.setMsg(ResponseCode.SUCCESS_TOKEN.getMsg());
            responseVo.setData(tokenValue);
            return responseVo;
        }
        return new Response();
    }


    @ApiIdempotent
    @PostMapping("/test/Idempotence")
    public Response testIdempotence() {
        String businessResult = testService.testIdempotence();
        if (StrUtil.isNotEmpty(businessResult)) {
            Response responseVo = new Response();
            responseVo.setStatus(ResponseCode.SUCCESS.getCode());
            responseVo.setMsg(ResponseCode.SUCCESS.getMsg());
            return responseVo;
        }
        return new Response();
    }
}
