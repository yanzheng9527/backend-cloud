package com.randy.backend.web.controller;

import com.randy.backend.dao.mapper.PersonMapper;
import com.randy.backend.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("人员信息接口")
@RestController
@Transactional
public class PersonController {

  @Autowired private PersonMapper personMapper;

  @ApiOperation(value = "创建人员信息")
  @ApiImplicitParam(name = "person", value = "用户信息", required = true, dataType = "Person")
  @RequestMapping(value = "/createPerson", method = RequestMethod.POST)
  public Person createPerson(@RequestBody Person person) {
    personMapper.insert(person);
    return person;
  }

  @ApiOperation(value = "查询单个人员信息")
  @ApiImplicitParam(
      name = "name",
      value = "人员姓名",
      paramType = "path",
      required = true,
      dataType = "String")
  @RequestMapping(value = "/getPerson/{name}", method = RequestMethod.GET)
  public Person getPerson(@PathVariable String name) {
    return personMapper.getOne(name);
  }

  @ApiOperation(value = "查询所有人员信息")
  @RequestMapping(value = "/listPerson", method = RequestMethod.GET)
  public List<Person> listPerson() {
    return personMapper.getAll();
  }

  @ApiOperation(value = "删除人员信息")
  @ApiImplicitParam(
      name = "name",
      value = "人员姓名",
      paramType = "path",
      required = true,
      dataType = "String")
  @RequestMapping(value = "/deletePerson/{name}", method = RequestMethod.GET)
  public String deletePerson(@PathVariable String name) {
    personMapper.delete(name);
    return "success";
  }
}
