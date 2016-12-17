package com.sonymm.manager.mybatis.dao;

import com.sonymm.manager.core.BaseEntity;
import com.sonymm.manager.core.page.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/15 17:28
 */
public interface GenericDao<T extends BaseEntity> {

    /**
     * 添加对象
     *
     * @Author suojx(1466200463@qq.com)
     */
    public Serializable save(T entity);

    /**
     * 添加entity
     *
     * @Author suojx(1466200463@qq.com)
     */
    public Serializable save(String key, Object param);

    /**
     * 删除实体entity
     *
     * @Author suojx(1466200463@qq.com)
     */
    public void delete(T entity);

    /**
     * 批量删除实体entity
     *
     * @Author suojx(1466200463@qq.com)
     */
    public void delete(T[] entities);

    /**
     * 根据映射文件中对应的sqlKey以及参数删除数据
     *
     * @Author suojx(1466200463@qq.com)
     */
    public void delete(String key, Object param);

    /**
     * 返回更新记录数
     *
     * @Author suojx(1466200463@qq.com)
     */
    public void update(T entity);

    /**
     * 批量更新
     *
     * @Author suojx(1466200463@qq.com)
     */
    public void update(T[] entities);

    /**
     * 根据获取映射文件中对应的SQL语句更新数据
     *
     * @Author suojx(1466200463@qq.com)
     */
    public void update(String key, Object param);

    /**
     * 根据key获取映射文件中的数据
     *
     * @Author suojx(1466200463@qq.com)
     */
    public List<T> find(String key);

    /**
     * 根据分页参数Page获取List集
     *
     * @Author suojx(1466200463@qq.com)
     */
    public List<T> find(String key, Object param, Page page);

    public List<T> find(String key, Object param);

    /**
     * 获取单条记录
     *
     * @Author suojx(1466200463@qq.com)
     */
    public T findUnique(String key, Object param);

    /**
     * 根据获取映射文件中对应的数据查询单列的值
     *
     * @Author suojx(1466200463@qq.com)
     */
    public <R> List<R> findColumn(String key, Class<R> returnClass, Object param);

    /**
     * 查询某列的所有值
     *
     * @Author suojx(1466200463@qq.com)
     */
    public <R> List<R> findColumn(String key, Class<R> returnClass);

    /**
     * 根据获取映射文件中对应的数据查询一条记录单列的值
     *
     * @Author suojx(1466200463@qq.com)
     */
    public <R> R findOneColumn(String key, Class<R> returnClass, Object param);

    /**
     * 查询列表返回List<Map<String, Object>>
     *
     * @Author suojx(1466200463@qq.com)
     */
    public List<Map<String, Object>> findMap(String key);

    public List<Map<String, Object>> findMap(String key, Object param);

    public List<Map<String, Object>> findMap(String key, Object param, Page page);
}
