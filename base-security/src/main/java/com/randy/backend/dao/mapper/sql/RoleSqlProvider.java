package com.randy.backend.dao.mapper.sql;

import org.apache.ibatis.annotations.Param;

public class RoleSqlProvider {
  public String getRolesByUserId(@Param("userId") String userId) {
    String sql = "select a.* from role a inner join user_role_rel b on a.id = b.role_id ";
    sql += " where 1=1 and b.user_id = #{userId} ";
    System.out.println("getRolesByUserId:" + sql);
    return sql;
  }
}
