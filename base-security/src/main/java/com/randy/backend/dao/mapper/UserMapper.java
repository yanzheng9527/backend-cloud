package com.randy.backend.dao.mapper;

import com.randy.backend.common.BaseMapper;
import com.randy.backend.dao.mapper.sql.UserSqlProvider;
import com.randy.backend.model.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
// @Dao("dao test")
public interface UserMapper extends BaseMapper<User> {
  @SelectProvider(type = UserSqlProvider.class, method = "aopTest")
  //  @Log("log Test")
  List<User> aopTest();
}
