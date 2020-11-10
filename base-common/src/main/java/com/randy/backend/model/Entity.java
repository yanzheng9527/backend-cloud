package com.randy.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class Entity implements Serializable {
  private static final long serialVersionUID = 1L;

  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  protected String id;

  //  @Transient protected Integer pageNum;
  //  @Transient protected Integer pageSize;
  //  @Transient protected String flag;

  protected transient Integer pageNum;
  protected transient Integer pageSize;
  protected transient String flag;

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
