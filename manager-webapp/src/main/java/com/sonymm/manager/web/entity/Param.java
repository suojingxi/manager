package com.sonymm.manager.web.entity;

import com.sonymm.manager.core.BaseEntity;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 21:16
 */
public class Param extends BaseEntity {

    private String paramId;

    private String name;

    private String value;

    public String getParamId( ) {
        return paramId;
    }

    public void setParamId( String paramId ) {
        this.paramId = paramId;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getValue( ) {
        return value;
    }

    public void setValue( String value ) {
        this.value = value;
    }



}
