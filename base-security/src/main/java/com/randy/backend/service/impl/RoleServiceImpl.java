package com.randy.backend.service.impl;

import com.randy.backend.common.BaseServiceImpl;
import com.randy.backend.dao.mapper.RoleMapper;
import com.randy.backend.model.Role;
import com.randy.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
  @Autowired RoleMapper roleMapper;

  @Override
  public Set<Role> getRolesByUserId(String userId) {
    return roleMapper.getRolesByUserId(userId);
  }
}
