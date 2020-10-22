package com.randy.backend.model;

import java.io.Serializable;

public class Leave extends Entity implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer days;
  private String reason;
  private String auditStatus;

  public String getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(String auditStatus) {
    this.auditStatus = auditStatus;
  }

  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
