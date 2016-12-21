package com.sonymm.manager.web.service;

import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.entity.Dict;
import com.sonymm.manager.web.entity.pojo.JSTree;

import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface DictService {
    void add(Dict dict);
    List<Dict> getList(ParamFilter queryFilter);
    void update(Dict dict);
    List<JSTree> getTree();
    List<Dict> getListByParentId(String parentId);
    List<Dict> getCatagory();
    void delete(List<String> ids);
    Dict getById(String id);
}
