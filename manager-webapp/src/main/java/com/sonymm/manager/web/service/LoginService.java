package com.sonymm.manager.web.service;

import com.sonymm.manager.web.entity.User;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface LoginService {
    User doLogin(String account, String clientIp);
}
