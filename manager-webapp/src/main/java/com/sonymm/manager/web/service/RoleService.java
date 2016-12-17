package com.sonymm.manager.web.service;

import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.entity.Role;

import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface RoleService {
    void add(Role role);
    void delete(List<String> roleIds);
    void update(Role role);
    List<Role> getList(ParamFilter param);
    Role getByRoleId(String roleId);
    List getRoleMap();
}
