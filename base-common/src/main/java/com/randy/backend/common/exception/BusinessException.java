package com.randy.backend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "业务处理异常")
public class BusinessException extends RuntimeException {
  public BusinessException() {}

  public BusinessException(String message) {
    super(message);
  }
}
