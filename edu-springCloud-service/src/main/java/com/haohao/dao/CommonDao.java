package com.haohao.dao;

/**
 * @Desc 常用方法Dao
 * @Author xiekunliang
 * @Date 2018/5/9 14:46
 */
public interface CommonDao<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(T t);
}
