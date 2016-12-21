package com.sonymm.manager.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/19 18:01
 */
@Controller
public class LogoutController {

    @GetMapping("logout")
    public String logout() throws IOException {
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            subject.logout();
        }
        return "redirect:/login";
    }
}
