package com.sonymm.manager.web.shiro.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 16:01
 */
public class UrlPermission implements Permission {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    UrlPermission(String url){
        setUrl(url);
    }

    @Override
    public boolean implies(Permission permission) {
        if(!(permission instanceof UrlPermission)){
            return false;
        }
        UrlPermission urlPermission = (UrlPermission)permission;
        PatternMatcher patternMatcher = new AntPathMatcher();
        return patternMatcher.matches(this.getUrl(), urlPermission.getUrl());
    }
}
