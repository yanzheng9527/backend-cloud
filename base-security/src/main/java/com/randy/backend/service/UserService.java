package com.randy.backend.service;

import com.randy.backend.common.MyBaseService;
import com.randy.backend.common.MyPage;
import com.randy.backend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends MyBaseService<User> {
  //  PageInfo<User> query(String account, String phone, int currentPage, int pageSize);

  List<User> aopTest();

  List<User> aopTest2();

  MyPage<User> customPagingQuery(MyPage<User> page, String account, String phone);
}
