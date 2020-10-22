package com.randy.backend.service.impl;

import com.randy.backend.common.BaseServiceImpl;
import com.randy.backend.dao.mapper.AuthorizationMapper;
import com.randy.backend.model.Authorization;
import com.randy.backend.model.Permission;
import com.randy.backend.model.Role;
import com.randy.backend.service.AuthorizationService;
import com.randy.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
public class AuthorizationServiceImpl extends BaseServiceImpl<Authorization>
    implements AuthorizationService {
  @Autowired AuthorizationMapper authorizationMapper;
  @Autowired RoleService roleService;

  @Override
  public Set<Permission> getPermsByUserId(String userId) {
    Set<Role> roles = roleService.getRolesByUserId(userId);
    String roleIds = roles.stream().map(role -> role.getId()).collect(Collectors.joining(","));
    return authorizationMapper.getPermsByUserId(userId, roleIds);
  }

  @Override
  public List<Authorization> aopTest3() {
    return authorizationMapper.selectAll();
  }
}
