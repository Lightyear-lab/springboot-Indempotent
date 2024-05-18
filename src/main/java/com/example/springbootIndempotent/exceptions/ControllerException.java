package com.example.springbootIndempotent.exceptions;

import com.example.springbootIndempotent.common.ResponseCode;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-18 13:16
 */
public class ControllerException extends BaseException {
    public ControllerException(String msg) {
        super(msg);
    }
    public ControllerException(Integer code,String msg){
        super(code,msg);
    }
    public ControllerException(ResponseCode responseCode){
        super(responseCode.getCode(), responseCode.getMsg());
    }
}
