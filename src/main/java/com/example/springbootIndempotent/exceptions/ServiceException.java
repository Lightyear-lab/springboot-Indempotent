package com.example.springbootIndempotent.exceptions;

import com.example.springbootIndempotent.common.ResponseCode;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description 业务逻辑异常
 * @date 2024-05-18 12:39
 */
public class ServiceException extends BaseException{
    public ServiceException(String msg) {
        super(msg);
    }
    public ServiceException(Integer code,String msg){
        super(code,msg);
    }
    public ServiceException(ResponseCode responseCode){
        super(responseCode.getCode(), responseCode.getMsg());
    }
}
