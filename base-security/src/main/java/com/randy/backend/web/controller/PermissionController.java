package com.randy.backend.web.controller;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.Permission;
import com.randy.backend.service.PermissionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController extends MyBaseController<PermissionService, Permission> {}
