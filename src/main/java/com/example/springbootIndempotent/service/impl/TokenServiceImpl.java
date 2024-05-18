package com.example.springbootIndempotent.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.example.springbootIndempotent.common.ResponseCode;
import com.example.springbootIndempotent.exceptions.ServiceException;
import com.example.springbootIndempotent.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-18 11:54
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private static final String TOKEN_NAME = "token";
    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {
        //通过UUID来生成token
        String tokenValue = "idempotent:token:" + UUID.randomUUID().toString();
        //将token放入redis中，设置有效期为60S
        stringRedisTemplate.opsForValue().set(tokenValue, "0", 60, TimeUnit.SECONDS);
        return tokenValue;
    }


    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) {

        String token = request.getHeader(TOKEN_NAME);
        if (StrUtil.isBlank(token)) {// header中不存在token
            token = request.getParameter(TOKEN_NAME);
            if (StrUtil.isBlank(token)) {// parameter中也不存在token
                //没有携带token，抛异常，这里的异常需要全局捕获
                throw new ServiceException(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg()+",没有携带token");
            }
        }
        //token不存在，说明token已经被其他请求删除或者是非法的token

        if (!stringRedisTemplate.hasKey(token)) {
            throw new ServiceException(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg()+",非法的token");
        }

        boolean remove = stringRedisTemplate.delete(token);
        if (!remove) {
            //token删除失败，说明token已经被其他请求删除
            throw new ServiceException(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg()+",token已经被其他请求删除");

        }
        return true;
    }

}
