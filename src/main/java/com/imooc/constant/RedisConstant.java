package com.imooc.constant;

import javax.persistence.criteria.CriteriaBuilder;

/*
*redis常量
* */
public interface RedisConstant {
    String TOKEN_PREFIX="token_%s";

    Integer EXPIRE=7200;//两小时
}
