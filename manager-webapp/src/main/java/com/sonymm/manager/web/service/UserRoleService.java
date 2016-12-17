package com.sonymm.manager.web.service;

import com.sonymm.manager.web.entity.UserRole;

import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface UserRoleService {
    List<UserRole> getListByUserId(String userId);
    List<String> getRoleIdsByUserId(String userId);
    void add(String[] roleIds,String userId);
}
