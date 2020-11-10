package com.randy.backend.test.dao.mapper;

import com.randy.backend.common.MyBaseMapper;
import com.randy.backend.model.Authorization;
import org.springframework.stereotype.Repository;

@Repository("testMapper")
public interface TestMapper extends MyBaseMapper<Authorization> {}
