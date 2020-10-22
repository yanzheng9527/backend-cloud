package com.randy.backend.web.controller;

import com.randy.backend.common.BaseController;
import com.randy.backend.model.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {}
