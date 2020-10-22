package com.randy.backend.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "权限不足")
public class AuthorizationException extends RuntimeException {
  public AuthorizationException() {}

  public AuthorizationException(String message) {
    super(message);
  }
}
