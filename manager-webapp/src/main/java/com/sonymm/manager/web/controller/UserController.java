package com.sonymm.manager.web.controller;

import com.sonymm.manager.core.Response;
import com.sonymm.manager.core.page.Page;
import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.aop.annotaion.WebLogger;
import com.sonymm.manager.web.entity.User;
import com.sonymm.manager.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 18:16
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("listPage")
    public String list() {
        return "userList";
    }


    @ResponseBody
    @PostMapping("list")
    @WebLogger("查询用户列表")
    public Response list(@RequestBody ParamFilter queryFilter) {
        List userList = userService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(userList,page);
    }

    @ResponseBody
    @PostMapping("add")
    @WebLogger("添加用户")
    public Response add(@RequestBody User user) {
        checkNotNull(user, "用户不能为空");
        userService.add(user);
        return new Response("添加成功");
    }


    @ResponseBody
    @PostMapping("edit")
    @WebLogger("编辑用户")
    public Response edit(@RequestBody User user) {
        userService.update(user);
        return new Response("修改成功");
    }

    @ResponseBody
    @PostMapping("delete")
    @WebLogger("删除用户")
    public Response delete(@RequestBody List<String> userIds) {
        checkArgument((userIds != null && userIds.size() > 0), "用户编号不能为空");
        userService.delete(userIds);
        return new Response("删除成功");
    }

    @ResponseBody
    @PostMapping("resetPwd")
    @WebLogger("重置密码")
    public Response resetPwd(@RequestBody List<String> userIds) {
        checkArgument((userIds != null && userIds.size() > 0), "用户编号不能为空");
        userService.updateDefaultPwd(userIds);
        return new Response("重置成功");
    }


    @ResponseBody
    @PostMapping("changePwd")
    @WebLogger("更改密码")
    public Response changePwd(String originPwd, String confirmPwd, String newPwd) {
        userService.updatePwd(originPwd, newPwd, confirmPwd);
        return new Response("更改密码成功");
    }

    @ResponseBody
    @PostMapping("detail")
    @WebLogger("查询用户详细")
    public Response detail(@RequestBody String userId) {
        Map user = userService.getDetail(userId);
        return new Response(user);
    }
}
