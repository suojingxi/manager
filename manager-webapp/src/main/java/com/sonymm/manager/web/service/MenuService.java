package com.sonymm.manager.web.service;

import com.sonymm.manager.core.Response;
import com.sonymm.manager.mybatis.ParamFilter;
import com.sonymm.manager.web.entity.Menu;
import com.sonymm.manager.web.entity.pojo.MenuTitle;

import java.util.List;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 16:23
 */
public interface MenuService {
    void add(Menu menu);
    void delete(List<String> menuIds);
    void update(Menu menu);
    List<MenuTitle> getListByRoleId(String roleId);
    List<Menu> getList(ParamFilter param);
    List<Menu> getByParentId(String menuId);
    Response getResTree(String roleId);
    Response getSelectResTree();
    Menu detail(String resId);
    Response getTree();
}
