package com.randy.backend.model;

public class WorkflowEntity extends Entity {
  // 业务数据上放上processInstanceId用于简化查询功能。
  protected String processInstanceId;
  protected String taskId;

  public String getProcessInstanceId() {
    return processInstanceId;
  }

  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }
}
