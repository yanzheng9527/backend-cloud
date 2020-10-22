package com.randy.backend.service.impl;

import com.randy.backend.common.BaseServiceImpl;
import com.randy.backend.model.Permission;
import com.randy.backend.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission>
    implements PermissionService {}
