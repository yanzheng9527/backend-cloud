package com.randy.backend.service;

import com.github.pagehelper.PageInfo;
import com.randy.backend.common.BaseService;
import com.randy.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends BaseService<User> {
  PageInfo<User> query(String account, String phone, int currentPage, int pageSize);

  User findByAccount(String username);

  List<User> aopTest();

  List<User> aopTest2();
}
