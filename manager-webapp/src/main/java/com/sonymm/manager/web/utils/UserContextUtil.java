package com.sonymm.manager.web.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 1:58
 */
public class UserContextUtil {

    public static Session getSession(){
        Subject currentSubject = SecurityUtils.getSubject();
        return currentSubject.getSession();
    }

    public static String getUserId(){
        return (String)getAttribute("userId");
    }

    public static String getAccount(){
        return (String)getAttribute("account");
    }

    public static String getCurrentRoleId(){
        return (String)getAttribute("roleId");
    }

    public static Object getAttribute(String key){
        return getSession().getAttribute(key);
    }

    public static void setAttribute(String key, Object value){
        getSession().setAttribute(key, value);
    }
}
