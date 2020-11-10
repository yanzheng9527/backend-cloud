package com.randy.backend.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.randy.backend.model.Entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyBaseService<T extends Entity> extends IService<T> {

  MyPage<T> pagingQuery(List<SqlParam> sqlParams, int currentPage, int pageSize);

  //  <M extends BaseMapper<T>> M getMapper();
  //
  //  T selectById(String id);
  //
  //  T selectOne(T t);
  //
  //  List<T> select(T t);
  //
  //  List<T> selectAll();
  //
  //  PageInfo<T> pagingAll();
  //
  //  PageInfo<T> pagingAll(int currentPage, int pageSize);
  //
  //  PageInfo<T> pagingQuery(List<SqlParam> sqlParams, int currentPage, int pageSize, Class clazz);
  //
  //  PageInfo<T> pagingList(T entity, int currentPage, int pageSize);
  //
  //  String insert(T entity, boolean generateId);
  //
  //  String insert(T entity);
  //
  //  String insertSelective(T entity, boolean generateId);
  //
  //  String insertSelective(T entity);
  //
  //  int update(T entity);
  //
  //  int updateSelective(T entity);
  //
  //  int deleteById(String id);
  //
  //  int deleteByIds(Class<T> clazz, List<String> ids);
  //
  //  int delete(T entity);
  //
  //  List<T> selectByCondition(Object condition);
  //
  //  int selectCount(T entity);
  //
  //  int selectCountByCondition(Object condition);
  //
  //  default String getOrderByClause() {
  //    return "";
  //  }
}
