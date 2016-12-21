package com.sonymm.manager.web.controller;

import com.sonymm.manager.core.Response;
import com.sonymm.manager.core.page.Page;
import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.entity.WebLog;
import com.sonymm.manager.web.service.WebLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 18:18
 */
@Controller
@RequestMapping("webLog")
public class WebLogController {

    @Resource
    private WebLogService webLogService;

    @GetMapping("list")
    public String list(){
        return "webLogList";
    }

    @ResponseBody
    @PostMapping("list")
    public Response list(@RequestBody ParamFilter queryFilter){
        List<WebLog> webLogList = webLogService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(webLogList,page);
    }
}
