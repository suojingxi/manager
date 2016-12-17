package com.sonymm.manager.web.exception;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 15:21
 */
public class BusinessException {
    private String type;
    private int code;
    private String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
