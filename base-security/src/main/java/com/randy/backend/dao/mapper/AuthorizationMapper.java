package com.randy.backend.dao.mapper;

import com.randy.backend.common.MyBaseMapper;
import com.randy.backend.dao.mapper.sql.AuthorizationSqlProvider;
import com.randy.backend.model.Authorization;
import com.randy.backend.model.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("authorizationMapper")
@Primary
public interface AuthorizationMapper extends MyBaseMapper<Authorization> {
  @SelectProvider(type = AuthorizationSqlProvider.class, method = "getPermsByUserId")
  Set<Permission> getPermsByUserId(
      @Param("userId") String userId, @Param("roleIds") String roleIds);
}
