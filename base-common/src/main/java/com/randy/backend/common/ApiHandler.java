package com.randy.backend.common;

import com.randy.backend.model.Dto;
import org.springframework.stereotype.Component;

@Component
public class ApiHandler {

  public <T> Dto<T> responseDto(T entityResults) {
    Dto dto = new Dto();
    dto.setData(entityResults);
    return dto;
  }
}
