package com.randy.backend.web.controller;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.UserRoleRel;
import com.randy.backend.service.UserRoleRelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRoleRel")
public class UserRoleRelController extends MyBaseController<UserRoleRelService, UserRoleRel> {}
