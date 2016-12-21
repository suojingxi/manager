package com.sonymm.manager.core;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/15 13:59
 */
public interface ResponseCode {

    /**
     * 成功
     */
    Integer SUCCESS = 0;

    /**
     * 失败
     */
    Integer ERROR = 1;

    /**
     * 参数有误：参数不能为空
     */
    Integer INVALID_PARAM = 2;

    Integer EXSIED = 3;

    Integer LOCKED = 4;

    Integer PASSWORD_ERROR = 5;

    Integer NEED_LOGIN = 6;

    ThreadLocal<Integer> INSUFFICIENT_PRIVILEGES = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 7;
        }
    };

    Integer NOT_FOUND = 404;
}
