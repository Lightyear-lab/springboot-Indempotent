package com.example.springbootIndempotent.exceptions;

import com.example.springbootIndempotent.common.ResponseCode;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-18 12:19
 */
public class BaseException extends RuntimeException {
    private Integer code=0;
    public BaseException(String msg) {
        super(msg);
    }
    public BaseException(Integer code,String msg){
        super(msg);
        this.code=code;
    }
    public BaseException(ResponseCode responseCode){
        super(responseCode.getMsg());
        this.code= responseCode.getCode();
    }
    public Integer getCode(){
        return code;
    }
}
