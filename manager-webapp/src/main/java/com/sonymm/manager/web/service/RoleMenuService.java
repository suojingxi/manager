package com.sonymm.manager.web.service;

import com.sonymm.manager.web.entity.RoleMenu;

import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface RoleMenuService {
    List<RoleMenu> getList(String roleId);
    void update(String roleId, String[] menuIds);
    List<String> getMenuByRole(String roleId);
}
