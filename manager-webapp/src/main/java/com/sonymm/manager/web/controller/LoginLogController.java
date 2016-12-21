package com.sonymm.manager.web.controller;

import com.sonymm.manager.core.Response;
import com.sonymm.manager.core.page.Page;
import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.aop.annotaion.WebLogger;
import com.sonymm.manager.web.entity.LoginLog;
import com.sonymm.manager.web.service.LoginLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 17:57
 */
@Controller
@RequestMapping("loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @GetMapping("listPage")
    public String list(){
        return "loginLogList";
    }

    @ResponseBody
    @PostMapping("list")
    @WebLogger("查询登录日志列表")
    public Response list(@RequestBody ParamFilter queryFilter){
        List<LoginLog> loginLogList = loginLogService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(loginLogList, page);
    }
}
