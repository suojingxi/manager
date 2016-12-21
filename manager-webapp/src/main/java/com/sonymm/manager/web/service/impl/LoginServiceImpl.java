package com.sonymm.manager.web.service.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.sonymm.manager.web.dao.UserDao;
import com.sonymm.manager.web.entity.User;
import com.sonymm.manager.web.service.LoginService;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:38
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserDao userDao;

    @Override
    public User doLogin(String account, String clientIp) {
        checkArgument(!Strings.isNullOrEmpty(account), "账号不能为空");
        String accountToUse = account.toUpperCase();
        User user = userDao.findUnique("getByAccount", accountToUse);
        if(user == null){
            //账号不存在
            throw new UnknownAccountException();
        }
        if(user.getIsLock()){
            //账号被锁定
            throw new LockedAccountException();
        }
        String userId = user.getUserId();
        Map<String, Object> updateParam = Maps.newHashMap();
        updateParam.put("loginTime", new Date());
        updateParam.put("loginIp", clientIp);
        updateParam.put("errorCount", 0);
        updateParam.put("userId", userId);
        userDao.update("updateLoginInfo", updateParam);
        return user;
    }
}
