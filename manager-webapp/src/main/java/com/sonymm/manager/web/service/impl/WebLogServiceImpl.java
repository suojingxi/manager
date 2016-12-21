package com.sonymm.manager.web.service.impl;

import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.dao.WebLogDao;
import com.sonymm.manager.web.entity.WebLog;
import com.sonymm.manager.web.service.WebLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:38
 */
@Service
public class WebLogServiceImpl implements WebLogService {

    @Resource
    private WebLogDao webLogDao;

    @Override
    public void add(WebLog webLog) {
        checkNotNull(webLog,"操作日志不能为空");
        webLogDao.save(webLog);
    }

    @Override
    public void delete(String[] webLogIds) {
        checkArgument(webLogIds!=null&& webLogIds.length>0,"操作日志编号不能为空");
        for(String webLogId : webLogIds){
            webLogDao.delete("delete",webLogId);
        }
    }

    @Override
    public void update(WebLog webLog) {
        checkNotNull(webLog,"操作日志不能为空");
        webLogDao.update(webLog);
    }

    @Override
    public List<WebLog> getList(ParamFilter paramFilter) {
        return webLogDao.find("getList", paramFilter.getParam(), paramFilter.getPage());
    }
}
