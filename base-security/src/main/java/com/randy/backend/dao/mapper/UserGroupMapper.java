package com.randy.backend.dao.mapper;

import com.randy.backend.model.UserGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupMapper {

  List<UserGroup> getAll();

  UserGroup getOne(String groupName);

  UserGroup getOneById(int id);

  void insert(UserGroup userGroup);

  void update(UserGroup userGroup);

  void delete(String groupName);

  void deleteById(int id);

  //    List<UserGroup> getAllForActiviti(GroupQueryImpl query);
}
