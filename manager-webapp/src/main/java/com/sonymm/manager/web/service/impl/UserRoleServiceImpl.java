package com.sonymm.manager.web.service.impl;

import com.google.common.base.Strings;
import com.sonymm.manager.web.dao.UserRoleDao;
import com.sonymm.manager.web.entity.UserRole;
import com.sonymm.manager.web.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:38
 */
@Service
public class UserRoleServiceImpl  implements UserRoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public List<UserRole> getListByUserId(String userId) {
        return userRoleDao.find("getListByUserId",userId);
    }

    @Override
    public List<String> getRoleIdsByUserId(String userId){
        return userRoleDao.findColumn( "getRoleIdsByUserId", String.class, userId );
    }

    @Override
    public void add(String[] roleIds,String userId) {
        checkArgument(!Strings.isNullOrEmpty(userId),"用户编号不能为空");
        userRoleDao.delete("deleteByUserId",userId);
        if(!Objects.isNull(roleIds)&& roleIds.length>0){
            for(String roleId : roleIds){
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                userRoleDao.save(userRole);
            }
        }else{
            userRoleDao.delete("deleteByUserId",userId);
        }
    }
}
