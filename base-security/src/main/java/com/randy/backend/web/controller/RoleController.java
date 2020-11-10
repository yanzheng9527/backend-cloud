package com.randy.backend.web.controller;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.Role;
import com.randy.backend.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends MyBaseController<RoleService, Role> {}
