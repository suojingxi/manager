package com.sonymm.manager.mybatis;

import com.sonymm.manager.core.page.Page;

import java.util.Map;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/15 17:18
 */
public class ParamFilter {

    private Page page;

    private Map<String, Object> param;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }
}
