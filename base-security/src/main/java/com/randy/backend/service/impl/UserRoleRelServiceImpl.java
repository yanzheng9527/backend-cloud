package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.UserRoleRelMapper;
import com.randy.backend.model.UserRoleRel;
import com.randy.backend.service.UserRoleRelService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleRelServiceImpl extends MyBaseServiceImpl<UserRoleRelMapper, UserRoleRel>
    implements UserRoleRelService {}
