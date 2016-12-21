package com.sonymm.manager.web.aop;

import com.google.common.base.Strings;
import com.sonymm.manager.core.IdGenerator;
import com.sonymm.manager.web.entity.LoginLog;
import com.sonymm.manager.web.service.LoginLogService;
import com.sonymm.manager.web.utils.ServletUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 15:47
 */
@Aspect
@Component
public class LoginAop {
    private Logger logger = LoggerFactory.getLogger(LoginAop.class);
    @Resource
    private LoginLogService loginLogService;

    @Pointcut(value="execution(* com.sonymm.manager.web.controller.LoginController.doLogin(..))))")
    private void loginLog(){

    }

    @Before("loginLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("loginLog()")
    public void doAfter() {
        String account = (String) ServletUtil.getRequest().getAttribute("account");
        String msg = (String) ServletUtil.getRequest().getAttribute("msg");
        if(Strings.isNullOrEmpty(account)){
            return;
        }
        if(!Strings.isNullOrEmpty(msg) ){
            this.writeLoginLog(LoginStatus.EXCEPTION.getStatus(),msg,account);
            return;
        }
        this.writeLoginLog(LoginStatus.NORMAL.getStatus(),null,account);
    }

    private void writeLoginLog(String status,String msg,String account) {
        String id = IdGenerator.getInstance().nextId();
        LoginLog loginLog = new LoginLog();
        loginLog.setLoginLogId(id);
        loginLog.setStatus(status);
        loginLog.setLoginAccount(account);
        loginLog.setLoginTime(new Date());
        loginLog.setLoginIp(ServletUtil.getIpAddr());
        if(!Strings.isNullOrEmpty(msg)){
            loginLog.setRemark(msg);
        }
        loginLogService.add(loginLog);
    }

    private enum LoginStatus {
        NORMAL("登录成功"), EXCEPTION("登录失败");
        private String status;

        LoginStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}
