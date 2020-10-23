package com.randy.backend.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {
  @Value("${common.version}")
  private String commonVersion;

  @Value("${security.version}")
  private String securityVersion;

  @RequestMapping("/hello")
  public String hello() {
    String str = "commonVersion:" + commonVersion + "; securityVersion:" + securityVersion;
    // 返回数据
    return str;
  }

  @GetMapping(value = "/hello/{string}")
  public String echo(@PathVariable String string) {
    return string;
  }
}
