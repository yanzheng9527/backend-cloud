package com.randy.backend.test.web.service;

import com.randy.backend.common.MyBaseService;
import com.randy.backend.model.Authorization;
import com.randy.backend.test.aop.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService extends MyBaseService<Authorization> {
  @Log("TestService test")
  List<Authorization> test1();
}
