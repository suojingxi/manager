package com.sonymm.manager.web.utils;

import com.google.common.base.Strings;
import com.sonymm.manager.core.utils.BeanUtil;
import com.sonymm.manager.web.entity.Menu;
import com.sonymm.manager.web.entity.pojo.JSTree;
import com.sonymm.manager.web.entity.pojo.SelectTree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 21:14
 */
public abstract class ResourceTreeUtil {

    /**
     * select 下拉组件数据对象
     *
     * @Author suojx(1466200463@qq.com)
     */
    private List<SelectTree> selectTree = new ArrayList<SelectTree>();

    /**
     * 生成select 下拉组件数据时遍历次数
     *
     * @Author suojx(1466200463@qq.com)
     */
    private int selectCnt = 0;

    public static List<JSTree> generateJSTree(List resourceList) {
        List<JSTree> jstreeList = new ArrayList<>();

        for (Object resource : resourceList) {
            Map<String,String> resMap = (Map<String, String>) resource;
            String isSelectd = (String) resMap.get("selectedId");
            JSTree jstree = new JSTree();
            jstree.setId(resMap.get("menuId").toString());
            jstree.setParent(resMap.get("parentId").toString());
            jstree.setText(resMap.get("name").toString());
            jstree.setIcon(BeanUtil.isEmpty(resMap.get("icon")) ? "fa fa-cog" : resMap.get("icon").toString());
            JSTree.State state = new JSTree().new State();
            state.setDisabled(false);
            state.setSelected(!Strings.isNullOrEmpty(isSelectd));
            state.setOpened(true);
            jstree.setState(state);
            jstreeList.add(jstree);
        }
        return jstreeList;
    }

    public List<SelectTree> getSelectTree(List<Menu> list, Integer parentId) {
        List<Menu> returnList = getChildResourceEntitys(list, parentId);
        recursionForSelect(returnList);
        return selectTree;
    }

    /**
     * 递归列表
     */
    private void recursionForSelect(List<Menu> list) {
        String str = "";
        for (int i = 0; i < selectCnt; i++) {
            str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        for (Menu re : list) {
            if (null == re.getParentId()) {
                str = "";
                selectCnt = 0;
            }
            SelectTree se = new SelectTree();
            se.setId(re.getMenuId());
            se.setText(str + re.getName());
            se.setName(re.getName());
            selectTree.add(se);
//			if ( re.getChildren( ).size( ) > 0 ) {
//				selectCnt++;
//				recursionForSelect( re.getChildren( ) );
//			}
        }
    }


    public List<Menu> getChildResourceEntitys(List<Menu> list, Integer parentId) {
        List<Menu> returnList = new ArrayList<>();
        Iterator<Menu> iterator;
        for (iterator = list.iterator(); iterator.hasNext(); ) {
            Menu t = iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (Integer.valueOf(t.getParentId()) == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<Menu> list, Menu t) {
        List<Menu> childList = getChildList(list, t);// 得到子节点列表
//		t.setChildren( childList );
        // 判断是否有子节点
        childList.stream().filter(tChild -> hasChild(list, tChild)).forEach(tChild -> {
            // 判断是否有子节点
            for (Menu n : childList) {
                recursionFn(list, n);
            }
        });
    }

    /**
     * 得到子节点列表
     */
    private List<Menu> getChildList(List<Menu> list, Menu t) {
        return list.stream().filter(n -> t.getType() != 2).filter(n -> Objects.equals(n.getParentId(), t.getMenuId())).collect(Collectors.toList());
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<Menu> list, Menu t) {
        return getChildList(list, t).size() > 0;
    }
}
