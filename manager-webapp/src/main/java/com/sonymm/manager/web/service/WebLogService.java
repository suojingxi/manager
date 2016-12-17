package com.sonymm.manager.web.service;

import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.entity.WebLog;

import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface WebLogService {
    void add(WebLog webLog);
    void delete(String[] webLogIds);
    void update(WebLog webLog);
    List<WebLog> getList(ParamFilter paramFilter);
}
