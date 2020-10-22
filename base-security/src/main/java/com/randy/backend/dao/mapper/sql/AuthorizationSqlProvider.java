package com.randy.backend.dao.mapper.sql;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationSqlProvider {
  private static final Logger logger = LoggerFactory.getLogger(AuthorizationSqlProvider.class);

  public String getPermsByUserId(@Param("userId") String userId, @Param("roleIds") String roleIds) {
    String sql =
        "select a.*,c.name resource_name,c.type resource_type,c.resource_level_name,c.url resource_url from permission a ";
    sql += " inner join authorization b on a.id = b.permission_id ";
    sql += " inner join resource c on a.resource_id = c.id ";
    sql += " where 1=1 and b.subject_type = 'ROLE' and b.subject_id in ('" + roleIds + "') ";
    logger.debug("getPermsByUserId:" + sql);
    return sql;
  }
}
