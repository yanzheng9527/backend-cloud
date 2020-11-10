package com.randy.backend.service;

import com.randy.backend.common.MyBaseService;
import com.randy.backend.model.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RoleService extends MyBaseService<Role> {
  Set<Role> getRolesByUserId(String userId);
}
