package com.sonymm.manager.web.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 16:05
 */
public class UrlPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String permissionString) {
        if(permissionString.startsWith("/")){
            return new UrlPermission(permissionString);
        }
        return new WildcardPermission(permissionString);
    }
}
