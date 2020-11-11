package com.randy.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.common.MyPage;
import com.randy.backend.dao.mapper.UserMapper;
import com.randy.backend.model.User;
import com.randy.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends MyBaseServiceImpl<UserMapper, User> implements UserService {
  //  @Autowired UserMapper userMapper;

  //  @Override
  //  public PageInfo<User> query(String account, String phone, int currentPage, int pageSize) {
  //    PageHelper.startPage(currentPage, pageSize, getOrderByClause());
  //    Condition condition = new Condition(User.class);
  //    Condition.Criteria criteria = condition.createCriteria();
  //    if (StringUtils.isNotBlank(account)) {
  //      criteria.andCondition("account like '%" + account + "%'");
  //    }
  //    if (StringUtils.isNotBlank(phone)) {
  //      criteria.andCondition("phone like '%" + phone + "%'");
  //    }
  //    return new PageInfo<>(mapper.selectByCondition(condition));
  //  }

  //  @Override
  //  public List<User> aopTest() {
  //    List<User> users = userMapper.aopTest();
  //    System.out.println("userMapper:" + userMapper.getClass());
  //    return users;
  //  }
  //
  //  @Override
  //  public List<User> aopTest2() {
  //    return userMapper.selectAll();
  //  }

  public User findByAccount(String account) {
    User user = new User();
    user.setAccount(account);
    User result = baseMapper.selectOne(new QueryWrapper<>(user));
    return result;
  }

  @Override
  public List<User> aopTest() {
    List<User> users = baseMapper.aopTest();
    System.out.println("userMapper:" + baseMapper.getClass());
    return users;
  }

  @Override
  public List<User> aopTest2() {
    return baseMapper.selectList(null);
  }

  @Override
  public MyPage<User> customPagingQuery(MyPage<User> page, String account, String phone) {
    MyPage<User> userPage = baseMapper.customPagingQuery(page, account, phone);
    return userPage;
  }
}
