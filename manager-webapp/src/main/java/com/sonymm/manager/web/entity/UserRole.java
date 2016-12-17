package com.sonymm.manager.web.entity;

import com.sonymm.manager.core.BaseEntity;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 22:45
 */
public class UserRole extends BaseEntity {

    private String userId;

    private String roleId;

    public String getUserId( ) {
        return userId;
    }

    public void setUserId( String userId ) {
        this.userId = userId;
    }

    public String getRoleId( ) {
        return roleId;
    }

    public void setRoleId( String roleId ) {
        this.roleId = roleId;
    }

}
