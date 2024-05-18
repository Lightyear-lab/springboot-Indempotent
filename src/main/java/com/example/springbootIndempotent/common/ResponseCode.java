package com.example.springbootIndempotent.common;

/**
 * @author Hollis
 * @email hycn2018@gmail.com
 * @description 响应状态码
 * @date 2024-05-18 12:29
 */
public enum ResponseCode {
    // 系统模块
    SUCCESS(0, "操作成功"),
    ERROR(1, "操作失败"),
    SERVER_ERROR(500, "服务器异常"),
    SERVICE_ERROR(1000, "业务层异常"),
    DAO_ERROR(2000, "dao层异常"),
    CONTROLLER_ERROR(3000, "控制层异常"),

    // 通用模块 1xxxx
    SUCCESS_TOKEN(3000, "获取TonKen成功"),
    ERROR_IDEMPOTENCE(101, "重复性操作"),
    ILLEGAL_ARGUMENT(10000, "参数不合法"),
    REPETITIVE_OPERATION(10001, "请勿重复操作"),
    ACCESS_LIMIT(10002, "请求太频繁, 请稍后再试");

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
