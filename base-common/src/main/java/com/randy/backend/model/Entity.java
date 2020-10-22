package com.randy.backend.model;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

public class Entity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected String id;

  @Transient protected Integer pageNum;
  @Transient protected Integer pageSize;

  @Transient protected String flag;
  // 业务数据上放上processInstanceId用于简化查询功能。
  //  protected String processInstanceId;
  //  protected String taskId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }
}
