package com.sonymm.manager.web.controller;

import com.google.common.base.Strings;
import com.sonymm.manager.core.Response;
import com.sonymm.manager.core.utils.JsonUtil;
import com.sonymm.manager.web.aop.annotaion.WebLogger;
import com.sonymm.manager.web.entity.RoleMenu;
import com.sonymm.manager.web.service.RoleMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 18:15
 */
@Controller
@RequestMapping("roleMenu")
public class RoleMenuController {

    @Resource
    private RoleMenuService roleMenuService;

    @ResponseBody
    @PostMapping("getList")
    @WebLogger("查询菜单权限列表")
    public Response getList(@RequestBody String json) {
        Map<String, String> param = JsonUtil.parseStringMap(json);
        assert param != null;
        String roleId = param.get("roleId");
        List<RoleMenu> roleMenuList = roleMenuService.getList(roleId);
        return new Response(roleMenuList);
    }

    @ResponseBody
    @PostMapping("add")
    @WebLogger("添加角色-菜单权限")
    public Response add(String roleId,@RequestParam(name="menuIds[]",required=false) String[] menuIds ) {
        checkArgument(!Strings.isNullOrEmpty(roleId), "角色编号不能为空");
        roleMenuService.update(roleId, menuIds);
        return new Response();
    }


    @ResponseBody
    @PostMapping("getMenuByRole")
    public Response getMenuByRole(@RequestBody  String roleId) {
        List<String> list = roleMenuService.getMenuByRole(roleId);
        return new Response(list);
    }

}
