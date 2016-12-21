package com.sonymm.manager.web.controller;

import com.sonymm.manager.web.entity.Role;
import com.sonymm.manager.web.entity.User;
import com.sonymm.manager.web.service.RoleService;
import com.sonymm.manager.web.service.UserService;
import com.sonymm.manager.web.utils.SystemInfoUtil;
import com.sonymm.manager.web.utils.UserContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 17:11
 */
@Controller
public class HomeController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @GetMapping("home")
    public String home(ModelMap modelMap){
        modelMap.put("systemInfo", SystemInfoUtil.getSystemInfo());
        User user = userService.getByUserId(UserContextUtil.getUserId());
        Role role = roleService.getByRoleId(UserContextUtil.getCurrentRoleId());
        modelMap.put("account", user.getAccount());
        modelMap.put("lastLoginIp", user.getLoginIp());
        modelMap.put("role", role.getName());
        return "home";
    }
}
