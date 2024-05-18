package com.example.springbootIndempotent.exceptions;

import com.example.springbootIndempotent.common.ResponseCode;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-18 12:35
 */
public class DAOException extends BaseException {
    public DAOException(String msg) {
        super(msg);
    }
    public DAOException(Integer code,String msg){
        super(code,msg);
    }
    public DAOException(ResponseCode responseCode){
        super(responseCode.getCode(), responseCode.getMsg());
    }
}
