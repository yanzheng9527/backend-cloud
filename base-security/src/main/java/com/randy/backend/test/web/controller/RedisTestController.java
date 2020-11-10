package com.randy.backend.test.web.controller;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.Dto;
import com.randy.backend.model.User;
import com.randy.backend.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController extends MyBaseController<UserService, User> {
  //  @Autowired protected UserService userService;

  //  @Cacheable("userCache10")
  //  @RequestMapping(value = "/redisTest1", method = RequestMethod.GET)
  //  public Dto redisTest1(String account) {
  //    int currentPage = 1;
  //    int pageSize = 10;
  //    SqlParam sqlParam1 = new SqlParam("account", DataType.STRING, account, SqlOperator.LIKE);
  //    List<SqlParam> sqlParams = new ArrayList<>();
  //    sqlParams.add(sqlParam1);
  //    PageInfo<User> pageInfo = userService.pagingQuery(sqlParams, currentPage, pageSize,
  // User.class);
  //    return apiHandler.responseDto(pageInfo);
  //  }

  @Cacheable("userCache20")
  @RequestMapping(value = "/redisTest2", method = RequestMethod.GET)
  public Dto redisTest2(String parameter) {
    return apiHandler.responseDto(parameter);
  }
}
