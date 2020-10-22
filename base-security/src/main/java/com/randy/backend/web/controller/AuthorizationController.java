package com.randy.backend.web.controller;

import com.randy.backend.common.BaseController;
import com.randy.backend.model.Authorization;
import com.randy.backend.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController extends BaseController<Authorization> {
  @Autowired protected AuthorizationService authorizationService;

  @RequestMapping(value = "/aopTest3", method = RequestMethod.GET)
  public List<Authorization> aopTest3() {
    List<Authorization> results = authorizationService.aopTest3();
    System.out.println("authorizationService:" + authorizationService.getClass());
    return results;
  }
}
