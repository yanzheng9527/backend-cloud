package com.randy.backend.service;

import com.randy.backend.common.BaseService;
import com.randy.backend.model.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RoleService extends BaseService<Role> {
  Set<Role> getRolesByUserId(String userId);
}
