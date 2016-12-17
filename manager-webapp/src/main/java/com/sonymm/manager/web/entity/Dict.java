package com.sonymm.manager.web.entity;

import com.sonymm.manager.core.BaseEntity;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 22:25
 */
public class Dict extends BaseEntity{
    private Long id;

    private String parentId;

    private String type;  // 字典分类，  字典值

    private String code;

    private String name;

    private int seq;

    private String isCatagory;

    public String getIsCatagory() {
        return isCatagory;
    }

    public void setIsCatagory(String isCatagory) {
        this.isCatagory = isCatagory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
