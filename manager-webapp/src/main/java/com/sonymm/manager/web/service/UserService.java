package com.sonymm.manager.web.service;

import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface UserService {
    List getList(ParamFilter param);
    void updateDefaultPwd(List<String> userIds);
    void update(User user);
    void add(User user);
    void updatePwd(String originPwd,String confirmPwd,String newPwd);
    void delete(List<String> userIds);
    Map getDetail(String userId);
    User getByUserId(String userId);
    List<String> getPermission(String account);
}
