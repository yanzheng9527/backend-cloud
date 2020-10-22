package com.randy.backend.common;

import com.randy.backend.enums.SqlOperator;

public class SqlParam {
  private String columnName;
  private DataType dataType;
  private String value;
  private SqlOperator sqlOperator;

  public SqlParam() {}

  public SqlParam(String columnName, DataType dataType, String value, SqlOperator sqlOperator) {
    this.columnName = columnName;
    this.dataType = dataType;
    this.value = value;
    this.sqlOperator = sqlOperator;
  }

  public DataType getDataType() {
    return dataType;
  }

  public void setDataType(DataType dataType) {
    this.dataType = dataType;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public SqlOperator getSqlOperator() {
    return sqlOperator;
  }

  public void setSqlOperator(SqlOperator sqlOperator) {
    this.sqlOperator = sqlOperator;
  }

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }
}
