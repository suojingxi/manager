package com.sonymm.manager.web.service;

import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.entity.LoginLog;

import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface LoginLogService {
    void add(LoginLog loginLog);
    void delete(String[] loginLogIds);
    List<LoginLog> getList(ParamFilter paramFilter);
}
