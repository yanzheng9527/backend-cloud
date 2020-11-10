package com.randy.backend.test.web.controller;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.Authorization;
import com.randy.backend.service.AuthorizationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends MyBaseController<AuthorizationService, Authorization> {
  //  @Autowired protected TestService service;
  //
  //  @RequestMapping(value = "/test1", method = RequestMethod.GET)
  //  //  @Log("TestController test")
  //  public List<Authorization> test1() {
  //    List<Authorization> results = service.test1();
  //    System.out.println("----------------------------test service:" + service.getClass());
  //    return results;
  //  }
}
