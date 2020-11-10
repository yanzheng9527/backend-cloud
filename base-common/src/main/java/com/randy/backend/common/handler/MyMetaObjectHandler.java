package com.randy.backend.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  private static final Logger logger = LoggerFactory.getLogger(MyMetaObjectHandler.class);

  @Override
  public void insertFill(MetaObject metaObject) {
    logger.debug("start insert fill ....");
    //    注意这里的fieldName是实体字段名称，而不是数据库字段名称！
    this.strictInsertFill(metaObject, "createTime", String.class, LocalDateTime.now().toString());
    this.strictInsertFill(metaObject, "createUser", String.class, "randy");
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    logger.debug("start update fill ....");
    this.strictUpdateFill(metaObject, "updateTime", String.class, LocalDateTime.now().toString());
    this.strictUpdateFill(metaObject, "updateUser", String.class, "leon");
  }
}
