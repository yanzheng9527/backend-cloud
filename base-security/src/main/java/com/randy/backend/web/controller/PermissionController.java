package com.randy.backend.web.controller;

import com.randy.backend.common.BaseController;
import com.randy.backend.model.Permission;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController<Permission> {}
