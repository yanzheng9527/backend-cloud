package com.randy.backend.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.randy.backend.model.Dto;
import com.randy.backend.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public abstract class MyBaseController<S extends MyBaseService<T>, T extends Entity> {
  @Autowired protected S myBaseService;

  @Autowired protected ApiHandler apiHandler;

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public Dto insert(@RequestBody T t) {
    boolean result = myBaseService.save(t);
    return apiHandler.responseDto(result);
  }

  //  @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
  //  public Dto insertSelective(@RequestBody T t) {
  //    String id = baseService.insertSelective(t);
  //    return apiHandler.responseDto(id);
  //  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public Dto update(@RequestBody T t) {
    boolean result = myBaseService.updateById(t);
    return apiHandler.responseDto(result);
  }

  //  @RequestMapping(value = "/updateSelective", method = RequestMethod.POST)
  //  public Dto updateSelective(@RequestBody T t) {
  //    int n = baseService.updateSelective(t);
  //    return apiHandler.responseDto(n);
  //  }

  @RequestMapping(value = "/selectById/{id}", method = RequestMethod.GET)
  public Dto selectById(@PathVariable String id) {
    return apiHandler.responseDto(myBaseService.getById(id));
  }

  @RequestMapping(value = "/selectOne", method = RequestMethod.GET)
  public Dto selectOne(T t) {
    return apiHandler.responseDto(myBaseService.getOne(new QueryWrapper(t)));
  }

  //  @RequestMapping(value = "/pagingAll", method = RequestMethod.GET)
  //  public Dto pagingAll(int currentPage, int pageSize) {
  //    PageInfo<T> pageInfo = baseService.pagingAll(currentPage, pageSize);
  //    return apiHandler.responseDto(pageInfo);
  //  }

  @RequestMapping(value = "/pagingAll", method = RequestMethod.GET)
  public Dto pagingAll(int currentPage, int pageSize) {
    MyPage<T> page = new MyPage<>(currentPage, pageSize);
    MyPage<T> userPage = myBaseService.page(page);
    return apiHandler.responseDto(userPage);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public Dto delete(T t) {
    boolean result = myBaseService.remove(new QueryWrapper(t));
    return apiHandler.responseDto(result);
  }

  @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET)
  public Dto deleteById(@PathVariable String id) {
    boolean result = myBaseService.removeById(id);
    return apiHandler.responseDto(result);
  }
}
