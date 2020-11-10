package com.randy.backend.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.randy.backend.enums.SqlOperator;
import com.randy.backend.model.Entity;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class MyBaseServiceImpl<M extends BaseMapper<T>, T extends Entity> extends ServiceImpl<M, T>
    implements MyBaseService<T> {
  @Override
  public MyPage<T> pagingQuery(List<SqlParam> sqlParams, int currentPage, int pageSize) {
    MyPage<T> page = new MyPage<>(currentPage, pageSize);
    QueryWrapper<T> queryWrapper = new QueryWrapper();
    for (int i = 0; i < sqlParams.size(); i++) {
      SqlParam sqlParam = sqlParams.get(i);
      SqlOperator sqlOperator = sqlParam.getSqlOperator();
      DataType dataType = sqlParam.getDataType();
      String value = sqlParam.getValue();
      if (StringUtils.isNotBlank(value)) {
        switch (sqlOperator) {
          case LIKE:
            queryWrapper.like(sqlParam.getColumnName(), value);
            break;
          case EQUAL:
            queryWrapper.eq(sqlParam.getColumnName(), DataUtils.getDataValue(dataType, value));
            break;
        }
      }
    }
    MyPage<T> MyPage = this.page(page, queryWrapper);
    return MyPage;
  }

  //  protected static final int PAGE_NUM = 1;
  //  protected static final int PAGE_SIZE = 10;
  //
  //  @Autowired protected BaseMapper<T> mapper;
  //
  //  @Override
  //  public <M extends BaseMapper<T>> M getMapper() {
  //    return (M) mapper;
  //  }
  //
  //  @Override
  //  public T selectById(String id) {
  //    return mapper.selectByPrimaryKey(id);
  //  }
  //
  //  @Override
  //  public T selectOne(T entity) {
  //    return mapper.selectOne(entity);
  //  }
  //
  //  @Override
  //  public List<T> select(T entity) {
  //    return mapper.select(entity);
  //  }
  //
  //  @Override
  //  public List<T> selectAll() {
  //    return mapper.selectAll();
  //  }
  //
  //  @Override
  //  public PageInfo<T> pagingAll() {
  //    return pagingAll(PAGE_NUM, PAGE_SIZE);
  //  }
  //
  //  @Override
  //  public PageInfo<T> pagingAll(int currentPage, int pageSize) {
  //    PageHelper.startPage(currentPage, pageSize, getOrderByClause());
  //    return new PageInfo<T>(mapper.selectAll());
  //  }
  //
  //  @Override
  //  public PageInfo<T> pagingQuery(
  //      List<SqlParam> sqlParams, int currentPage, int pageSize, Class clazz) {
  //    PageHelper.startPage(currentPage, pageSize, getOrderByClause());
  //    Condition condition = new Condition(clazz);
  //    Condition.Criteria criteria = condition.createCriteria();
  //    for (int i = 0; i < sqlParams.size(); i++) {
  //      SqlParam sqlParam = sqlParams.get(i);
  //      SqlOperator sqlOperator = sqlParam.getSqlOperator();
  //      DataType dataType = sqlParam.getDataType();
  //      String value = sqlParam.getValue();
  //      if (StringUtils.isNotBlank(value)) {
  //        switch (sqlOperator) {
  //          case LIKE:
  //            criteria.andLike(sqlParam.getColumnName(), "%" + value + "%");
  //            break;
  //          case EQUAL:
  //            criteria.andEqualTo(sqlParam.getColumnName(), DataUtils.getDataValue(dataType,
  // value));
  //            break;
  //        }
  //      }
  //    }
  //    return new PageInfo<>(mapper.selectByCondition(condition));
  //  }
  //
  //  @Override
  //  public PageInfo<T> pagingList(T entity, int currentPage, int pageSize) {
  //    PageHelper.startPage(currentPage, pageSize);
  //    return new PageInfo<T>(mapper.select(entity));
  //  }
  //
  //  @Override
  //  public String insert(T entity, boolean generateId) {
  //    if (generateId) {
  //      entity.setId(UUID.randomUUID().toString());
  //    }
  //    mapper.insert(entity);
  //    return entity.getId();
  //  }
  //
  //  public String insert(T entity) {
  //    return insert(entity, true);
  //  }
  //
  //  @Override
  //  public String insertSelective(T entity, boolean generateId) {
  //    if (generateId) {
  //      entity.setId(UUID.randomUUID().toString());
  //    }
  //    entity.setId(UUID.randomUUID().toString());
  //    mapper.insertSelective(entity);
  //    return entity.getId();
  //  }
  //
  //  public String insertSelective(T entity) {
  //    return insertSelective(entity, true);
  //  }
  //
  //  @Override
  //  public int update(T entity) {
  //    return mapper.updateByPrimaryKey(entity);
  //  }
  //
  //  @Override
  //  public int updateSelective(T entity) {
  //    return mapper.updateByPrimaryKeySelective(entity);
  //  }
  //
  //  @Override
  //  public int deleteById(String id) {
  //    return mapper.deleteByPrimaryKey(id);
  //  }
  //
  //  @Override
  //  public int deleteByIds(Class<T> clazz, List<String> ids) {
  //    Example example = new Example(clazz);
  //    example.createCriteria().andIn("id", ids);
  //    return mapper.deleteByExample(example);
  //  }
  //
  //  @Override
  //  public int delete(T entity) {
  //    return mapper.delete(entity);
  //  }
  //
  //  @Override
  //  public int selectCount(T entity) {
  //    return mapper.selectCount(entity);
  //  }
  //
  //  @Override
  //  public int selectCountByCondition(Object condition) {
  //    return mapper.selectCountByCondition(condition);
  //  }
  //
  //  @Override
  //  public List<T> selectByCondition(Object condition) {
  //    return mapper.selectByCondition(condition);
  //  }
}
