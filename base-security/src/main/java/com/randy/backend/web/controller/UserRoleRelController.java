package com.randy.backend.web.controller;

import com.randy.backend.common.BaseController;
import com.randy.backend.model.UserRoleRel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userRoleRel")
public class UserRoleRelController extends BaseController<UserRoleRel> {}
