package com.randy.backend.common;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

// xf
@Repository
@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, ConditionMapper<T> {}
