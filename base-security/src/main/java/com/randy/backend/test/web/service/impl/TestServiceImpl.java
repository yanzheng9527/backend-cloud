package com.randy.backend.test.web.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.AuthorizationMapper;
import com.randy.backend.model.Authorization;
import com.randy.backend.test.dao.mapper.TestMapper;
import com.randy.backend.test.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl extends MyBaseServiceImpl<AuthorizationMapper, Authorization>
    implements TestService {

  @Autowired TestMapper mapper;

  @Override
  //  @Log("TestServiceImpl test")
  public List<Authorization> test1() {
    List<Authorization> results = mapper.selectList(null);
    return results;
  }
}
