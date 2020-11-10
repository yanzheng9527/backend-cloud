package com.randy.backend.dao.mapper;

import com.randy.backend.common.MyBaseMapper;
import com.randy.backend.common.MyPage;
import com.randy.backend.dao.mapper.sql.UserSqlProvider;
import com.randy.backend.model.User;
import com.randy.backend.test.aop.Log;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

// @Repository("userMapper")
// @Dao("dao test")
public interface UserMapper extends MyBaseMapper<User> {
  @SelectProvider(type = UserSqlProvider.class, method = "aopTest")
  @Log("log Test")
  List<User> aopTest();

  @SelectProvider(type = UserSqlProvider.class, method = "customPagingQuery")
  MyPage<User> customPagingQuery(MyPage<User> page, String account, String phone);
}
