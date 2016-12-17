package com.sonymm.manager.web.utils;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/16 18:19
 */
public class Constants {
    public static final String ALGORITHM_NAME = "SHA-256";//加密算法
    public static final int HASH_ITERATIONS = 2;//加密次数
    public static final Set<Integer> STATUS_SET = Sets.newHashSet(0, 1);
}
