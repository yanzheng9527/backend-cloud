package com.randy.backend.service;

import com.randy.backend.common.MyBaseService;
import com.randy.backend.model.Authorization;
import com.randy.backend.model.Permission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AuthorizationService extends MyBaseService<Authorization> {
  Set<Permission> getPermsByUserId(String userId);

  List<Authorization> aopTest3();
}
