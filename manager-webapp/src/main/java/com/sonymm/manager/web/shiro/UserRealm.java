package com.sonymm.manager.web.shiro;

import com.google.common.collect.Sets;
import com.sonymm.manager.web.entity.User;
import com.sonymm.manager.web.service.LoginService;
import com.sonymm.manager.web.service.UserService;
import com.sonymm.manager.web.utils.ServletUtil;
import com.sonymm.manager.web.utils.UserContextUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 15:40
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private LoginService loginService;

    public UserRealm(){
        setName("UserRealm");
    }

    private PermissionResolver permissionResolver;

    public PermissionResolver getPermissionResolver(){
        return permissionResolver;
    }

    public void setPermissionResolver(PermissionResolver permissionResolver){
        this.permissionResolver = permissionResolver;
    }

    //权限资源角色
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //add Permission Menu
        simpleAuthorizationInfo.setStringPermissions(Sets.newHashSet(userService.getPermission(username)));
        //add Roles String[Set<String> roles]
        //simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String account = usernamePasswordToken.getUsername();
        User user = loginService.doLogin(account, ServletUtil.getIpAddr());//登录日志
        if(user == null){
            throw new UnknownAccountException("账号不存在");
        }
        if(user.getIsLock()){
            throw new LockedAccountException("用户已经被锁定");
        }
        usernamePasswordToken.setPassword(user.getPassword().toCharArray());
        //用 info 中的 password 比较 token 中的 password 密码比较
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(account, user.getPassword(), ByteSource.Util.bytes(account), getName());
        UserContextUtil.setAttribute("currentUser", user);
        return simpleAuthenticationInfo;
    }
}
