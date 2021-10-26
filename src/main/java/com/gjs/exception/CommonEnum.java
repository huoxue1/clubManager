package com.gjs.exception;

public enum CommonEnum implements ExceptionInfo {


    SUCCESS(1200, "成功!"),
    BODY_NOT_MATCH(1400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(1401,"请求的数字签名不匹配!"),
    NOT_FOUND(1404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(1500, "服务器内部错误!"),
    SERVER_BUSY(1503,"服务器正忙，请稍后再试!");


    public int code;
    public String msg;

    CommonEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
