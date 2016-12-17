package com.sonymm.manager.web.entity;

import com.sonymm.manager.core.BaseEntity;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 22:42
 */
public class RoleMenu extends BaseEntity {

    private String roleId;

    private String menuId;

    public String getRoleId( ) {
        return roleId;
    }

    public void setRoleId( String roleId ) {
        this.roleId = roleId;
    }

    public String getMenuId( ) {
        return menuId;
    }

    public void setMenuId( String menuId ) {
        this.menuId = menuId;
    }
}
