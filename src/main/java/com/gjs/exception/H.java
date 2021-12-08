package com.gjs.exception;

public class H {

    private String err;
    private Integer code;
    private String msg;
    private Object data;

    public H(){

    }


    public static H error(ExceptionInfo info){
        H h = new H();

        h.setCode(info.getCode());
        h.setMsg(info.getMsg());
        return h;
    }

    public static H error(int code,String msg){
        H h = new H();
        h.setCode(code);
        h.setMsg(msg);
        return h;
    }

    public static H error(String msg){
        H h = new H();
        h.setCode(1404);
        h.setMsg(msg);
        return h;
    }



    public static H success(Object data){
        H h = new H();
        h.setData(data);
        h.setCode(CommonEnum.SUCCESS.code);
        h.setMsg(CommonEnum.SUCCESS.msg);
        return h;
    }

    public static Object success() {
        return H.success("");
    }

    public static Object error() {
        return H.error("");
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public H(String err, Integer code, String msg, Object data) {
        this.err = err;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

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
