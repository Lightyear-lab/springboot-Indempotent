package com.example.springbootIndempotent.common;

import com.example.springbootIndempotent.exceptions.BaseException;
import com.example.springbootIndempotent.exceptions.ControllerException;
import com.example.springbootIndempotent.exceptions.DAOException;
import com.example.springbootIndempotent.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-18 12:37
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DAOException.class, ServiceException.class, ControllerException.class, ServletException.class})
    public Response serviceExceptionHandler(BaseException e){
        Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);
        logger.error("服务器出现异常，错误码：{}，错误信息：{}",e.getCode(),e.getMessage());
        return Response.error(e.getMessage(),e.getCode());
    }
}
