package com.randy.backend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.randy.backend.common.BaseServiceImpl;
import com.randy.backend.dao.mapper.UserMapper;
import com.randy.backend.model.User;
import com.randy.backend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
  @Autowired UserMapper userMapper;

  @Override
  public PageInfo<User> query(String account, String phone, int currentPage, int pageSize) {
    PageHelper.startPage(currentPage, pageSize, getOrderByClause());
    Condition condition = new Condition(User.class);
    Condition.Criteria criteria = condition.createCriteria();
    if (StringUtils.isNotBlank(account)) {
      criteria.andCondition("account like '%" + account + "%'");
    }
    if (StringUtils.isNotBlank(phone)) {
      criteria.andCondition("phone like '%" + phone + "%'");
    }
    return new PageInfo<>(mapper.selectByCondition(condition));
  }

  @Override
  public List<User> aopTest() {
    List<User> users = userMapper.aopTest();
    System.out.println("userMapper:" + userMapper.getClass());
    return users;
  }

  @Override
  public List<User> aopTest2() {
    return userMapper.selectAll();
  }
}
