package com.sonymm.manager.web.entity;

import com.sonymm.manager.core.BaseEntity;

import java.util.Date;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 22:26
 */
public class LoginLog extends BaseEntity {

    private String loginLogId;

    private String loginAccount;

    private Date loginTime;

    private String loginIp;

    private String status;

    public String getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(String loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
