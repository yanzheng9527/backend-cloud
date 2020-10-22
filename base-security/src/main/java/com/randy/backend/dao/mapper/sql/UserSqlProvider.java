package com.randy.backend.dao.mapper.sql;

public class UserSqlProvider {
  public String aopTest() {
    String sql = "select * from user ";
    System.out.println("aopTest:" + sql);
    return sql;
  }
}
