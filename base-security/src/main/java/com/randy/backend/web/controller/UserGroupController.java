package com.randy.backend.web.controller;

import com.randy.backend.dao.mapper.UserGroupMapper;
import com.randy.backend.model.UserGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("用户组信息接口")
@RestController
@Transactional
@CrossOrigin
public class UserGroupController {

  @Autowired private UserGroupMapper userGroupMapper;

  @ApiOperation(value = "创建用户组信息")
  @ApiImplicitParam(name = "userGroup", value = "用户组信息", required = true, dataType = "UserGroup")
  @RequestMapping(value = "/createUserGroup", method = RequestMethod.POST)
  public UserGroup createUserGroup(@RequestBody UserGroup userGroup) {
    userGroupMapper.insert(userGroup);
    return userGroup;
  }

  @ApiOperation(value = "查询单个用户组信息")
  @ApiImplicitParam(
      name = "groupName",
      value = "用户组名称",
      paramType = "path",
      required = true,
      dataType = "String")
  @RequestMapping(value = "/getUserGroup/{groupName}", method = RequestMethod.GET)
  public UserGroup getUserGroup(@PathVariable String groupName) {
    return userGroupMapper.getOne(groupName);
  }

  @ApiOperation(value = "查询单个用户组信息")
  @ApiImplicitParam(
      name = "id",
      value = "用户组Id",
      paramType = "path",
      required = true,
      dataType = "int")
  @RequestMapping(value = "/getUserGroupById/{id}", method = RequestMethod.GET)
  public UserGroup getUserGroupById(@PathVariable int id) {
    return userGroupMapper.getOneById(id);
  }

  @ApiOperation(value = "查询所有用户组信息")
  @RequestMapping(value = "/listUserGroup", method = RequestMethod.GET)
  public List<UserGroup> listUserGroup() {
    return userGroupMapper.getAll();
  }

  @ApiOperation(value = "修改单个用户组信息")
  @ApiImplicitParam(name = "userGroup", value = "用户组信息", required = true, dataType = "UserGroup")
  @RequestMapping(value = "/updateUserGroup", method = RequestMethod.POST)
  public void updateUser(@RequestBody UserGroup userGroup) {
    userGroupMapper.update(userGroup);
  }

  @ApiOperation(value = "删除用户组信息")
  @ApiImplicitParam(
      name = "userGroupName",
      value = "用户组名称",
      paramType = "path",
      required = true,
      dataType = "String")
  @RequestMapping(value = "/deleteUserGroup/{groupName}", method = RequestMethod.GET)
  public String deleteUserGroup(@PathVariable String groupName) {
    userGroupMapper.delete(groupName);
    return "success";
  }

  @ApiOperation(value = "删除用户组信息")
  @ApiImplicitParam(
      name = "id",
      value = "用户组Id",
      paramType = "path",
      required = true,
      dataType = "int")
  @RequestMapping(value = "/deleteUserGroupById/{id}", method = RequestMethod.GET)
  public String deleteUserGroup(@PathVariable int id) {
    userGroupMapper.deleteById(id);
    return "success";
  }
}
