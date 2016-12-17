package com.sonymm.manager.core;

import com.sonymm.manager.core.page.Page;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/15 14:04
 */
public class Response implements ResponseCode {

    private Object data;

    private Page page;

    //默认为0，表示响应正常
    private int code = 0;

    private String msg;

    public Response(){}

    public Response(Object data){
        this.data = data;
    }

    public Response(Object data, Page page){
        this.data = data;
        this.page = page;
    }

    public Response(String msg){
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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
