package com.randy.backend;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class MyServletInitializer extends SpringBootServletInitializer {
  @Override
  protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
    return builder.sources(WebApplication.class);
  }
}
