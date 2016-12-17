package com.sonymm.manager.web.entity;

import com.sonymm.manager.core.BaseEntity;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 22:28
 */
public class Role extends BaseEntity {
    private String roleId;

    private String name;

    private String sign;

    public String getRoleId( ) {
        return roleId;
    }

    public void setRoleId( String roleId ) {
        this.roleId = roleId;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getSign( ) {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }

}
