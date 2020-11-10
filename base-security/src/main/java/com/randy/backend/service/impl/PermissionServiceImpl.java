package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.PermissionMapper;
import com.randy.backend.model.Permission;
import com.randy.backend.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends MyBaseServiceImpl<PermissionMapper, Permission>
    implements PermissionService {}
