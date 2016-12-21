package com.sonymm.manager.web.controller;

import com.sonymm.manager.web.entity.pojo.MenuTitle;
import com.sonymm.manager.web.service.MenuService;
import com.sonymm.manager.web.utils.UserContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 17:16
 */
@Controller
public class IndexController {

    @Resource
    private MenuService menuService;

    @GetMapping(value = {"/", "/index"})
    public String index(ModelMap modelMap){
        String roleId = (String) UserContextUtil.getAttribute("roleId");
        List<MenuTitle> menuTitleList = menuService.getListByRoleId(roleId);
        modelMap.put("menuList", menuTitleList);
        modelMap.put("roleMap", UserContextUtil.getAttribute("roleMap"));
        return "index";
    }
}
