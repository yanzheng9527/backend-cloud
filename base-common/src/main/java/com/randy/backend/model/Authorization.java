package com.randy.backend.model;

public class Authorization extends Entity {
  private String subjectId;
  private String subjectType;
  private String subjectReferId;
  private String subjectReferType;
  private String permissionId;

  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }

  public String getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  public String getSubjectReferId() {
    return subjectReferId;
  }

  public void setSubjectReferId(String subjectReferId) {
    this.subjectReferId = subjectReferId;
  }

  public String getSubjectReferType() {
    return subjectReferType;
  }

  public void setSubjectReferType(String subjectReferType) {
    this.subjectReferType = subjectReferType;
  }

  public String getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(String permissionId) {
    this.permissionId = permissionId;
  }
}
