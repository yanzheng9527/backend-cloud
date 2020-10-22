package com.randy.backend.common;

import com.github.pagehelper.PageInfo;
import com.randy.backend.model.Dto;
import com.randy.backend.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class BaseController<T extends Entity> {
  @Autowired protected BaseService<T> service;

  @Autowired protected ApiHandler apiHandler;

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public Dto insert(@RequestBody T t) {
    String id = service.insert(t);
    return apiHandler.responseDto(id);
  }

  @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
  public Dto insertSelective(@RequestBody T t) {
    String id = service.insertSelective(t);
    return apiHandler.responseDto(id);
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public Dto update(@RequestBody T t) {
    int n = service.update(t);
    return apiHandler.responseDto(n);
  }

  @RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
  public Dto updateSelective(@RequestBody T t) {
    int n = service.updateSelective(t);
    return apiHandler.responseDto(n);
  }

  @RequestMapping(value = "/selectById/{id}", method = RequestMethod.GET)
  public Dto selectById(@PathVariable String id) {
    return apiHandler.responseDto(service.selectById(id));
  }

  @RequestMapping(value = "/selectOne", method = RequestMethod.GET)
  public Dto selectOne(T t) {
    return apiHandler.responseDto(service.selectOne(t));
  }

  @RequestMapping(value = "/pagingAll", method = RequestMethod.GET)
  public Dto pagingAll(int currentPage, int pageSize) {
    PageInfo<T> pageInfo = service.pagingAll(currentPage, pageSize);
    return apiHandler.responseDto(pageInfo);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public Dto delete(T t) {
    int n = service.delete(t);
    return apiHandler.responseDto(n);
  }

  @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET)
  public Dto deleteById(@PathVariable String id) {
    int n = service.deleteById(id);
    return apiHandler.responseDto(n);
  }
}
