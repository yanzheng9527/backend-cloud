package com.randy.backend.dao.mapper;

import com.randy.backend.common.BaseMapper;
import com.randy.backend.dao.mapper.sql.RoleSqlProvider;
import com.randy.backend.model.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("roleMapper")
public interface RoleMapper extends BaseMapper<Role> {
  @SelectProvider(type = RoleSqlProvider.class, method = "getRolesByUserId")
  Set<Role> getRolesByUserId(@Param("userId") String userId);
}
