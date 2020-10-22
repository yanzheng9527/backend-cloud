package com.randy.backend.model;

import java.io.Serializable;

public class Dto<T> implements Serializable {
  private static final long serialVersionUID = 1L;
  private int code = 200;
  private T data;
  private String message;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
