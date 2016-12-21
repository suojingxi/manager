package com.sonymm.manager.web.controller;

import com.google.common.base.Strings;
import com.sonymm.manager.core.Response;
import com.sonymm.manager.web.aop.annotaion.WebLogger;
import com.sonymm.manager.web.service.UserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 18:17
 */
@Controller
@RequestMapping("userRole")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    @ResponseBody
    @PostMapping("add")
    @WebLogger("添加用户-角色")
    public Response add(String userId, @RequestParam(name="roleIds[]",required=false)  String[] roleIds){
        checkArgument(!Strings.isNullOrEmpty(userId),"用户编号不能为空");
        userRoleService.add(roleIds,userId);
        return new Response("保存成功");
    }
}
