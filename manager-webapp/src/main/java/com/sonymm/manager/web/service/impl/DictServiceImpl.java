package com.sonymm.manager.web.service.impl;

import com.google.common.base.Strings;
import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.dao.DictDao;
import com.sonymm.manager.web.entity.Dict;
import com.sonymm.manager.web.entity.pojo.JSTree;
import com.sonymm.manager.web.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:38
 */
@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictDao dictDao;

    @Override
    public void add(Dict dict) {
        checkNotNull(dict, "字典信息不能为空");
        checkArgument(!Strings.isNullOrEmpty(dict.getCode()), "字典Code不能为空");
        checkArgument(!Strings.isNullOrEmpty(dict.getName()), "字典名称不能为空");
        checkArgument(!Strings.isNullOrEmpty(dict.getIsCatagory()), "字典类型不能为空");
        if (dict.getParentId() == null) {
            dict.setParentId("#");
        }
        dictDao.save(dict);
    }

    @Override
    public List<Dict> getList(ParamFilter queryFilter) {
        return dictDao.find("getList", queryFilter.getParam(), queryFilter.getPage());
    }

    @Override
    public void update(Dict dict) {
        dictDao.update(dict);
    }

    @Override
    public List<JSTree> getTree() {
        return dictDao.findMap("getTree");
    }

    @Override
    public List<Dict> getListByParentId(String parentId) {
        List<Dict> dictList = new LinkedList<Dict>();
        List<Dict> subList = dictDao.find("getListByParentId", parentId);
        Dict dict = dictDao.findUnique("getById", parentId);
        dictList.add(dict);
        if (subList != null && subList.size() > 0) {
            dictList.addAll(subList);
        }
        return dictList;
    }

    @Override
    public List<Dict> getCatagory() {
        return dictDao.find("getCatagory");
    }

    @Override
    public void delete(List<String> ids) {
        for (String id : ids) {
            dictDao.delete("delete", id);
        }
    }

    @Override
    public Dict getById(String id) {
        return dictDao.findUnique("getById", id);
    }
}
