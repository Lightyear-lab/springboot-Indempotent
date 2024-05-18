package com.example.springbootIndempotent.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.Serializable;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description TODO
 * @date 2024-05-18 13:12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response implements Serializable {

    private static final long serialVersionUID = 7498483649536881777L;

    private Integer status;

    private String msg;

    private Object data;

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static Response success() {
        return new Response(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static Response success(String msg) {
        return new Response(ResponseCode.SUCCESS.getCode(), msg, null);
    }

    public static Response success(Object data) {
        return new Response(ResponseCode.SUCCESS.getCode(), null, data);
    }

    public static Response success(String msg, Object data) {
        return new Response(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static Response error(String msg) {
        return new Response(ResponseCode.ERROR.getCode(), msg, null);
    }

    public static Response error(Object data) {
        return new Response(ResponseCode.ERROR.getCode(), null, data);
    }

    public static Response error(String msg, Object data) {
        return new Response(ResponseCode.ERROR.getCode(), msg, data);
    }

}