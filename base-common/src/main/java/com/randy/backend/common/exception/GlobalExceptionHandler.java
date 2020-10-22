package com.randy.backend.common.exception;

import com.randy.backend.model.Dto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  @ResponseBody
  public Object businessException(
      HttpServletRequest request, HttpServletResponse response, Exception e) {
    //    Map<String, Object> map = new HashMap<>();
    //    map.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
    //    map.put("message", e.getMessage());
    //    map.put("data", "exception");
    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    Dto dto = new Dto();
    dto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    dto.setMessage(e.getMessage());
    dto.setData("exception");
    return dto;
  }

  @ExceptionHandler(AuthorizationException.class)
  @ResponseBody
  public Object authorizationException(
      HttpServletRequest request, HttpServletResponse response, Exception e) {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    Dto dto = new Dto();
    dto.setCode(HttpStatus.UNAUTHORIZED.value());
    dto.setMessage(e.getMessage());
    dto.setData("exception");
    return dto;
  }
}
