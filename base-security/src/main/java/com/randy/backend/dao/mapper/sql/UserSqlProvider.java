package com.randy.backend.dao.mapper.sql;

import com.randy.backend.common.MyPage;
import com.randy.backend.model.User;
import org.apache.ibatis.annotations.Param;

public class UserSqlProvider {
  public String aopTest() {
    String sql = "select * from user ";
    System.out.println("aopTest:" + sql);
    return sql;
  }

  public String customPagingQuery(
      @Param("page") MyPage<User> page,
      @Param("account") String account,
      @Param("phone") String phone) {
    String sql =
        "select * from user as a inner join user_role_rel as b on a.id = b.user_id inner join role as c on b.role_id = c.id";
    sql = sql + " and account like '%" + account + "%'";
    sql = sql + " and phone like '%" + phone + "%'";
    System.out.println("customPagingQuery:" + sql);
    return sql;
  }
}
