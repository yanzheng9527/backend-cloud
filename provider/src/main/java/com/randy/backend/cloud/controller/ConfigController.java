package com.randy.backend.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
/** 否则客户端会受到服务端的更新消息，但是更新不了，因为不知道更新哪里的。 */
// @RefreshScope
public class ConfigController {
  //  @Value("${app.version}")
  //  private String version; //    @Value注解来获取server端参数的值
  //
  //  @Value("${server.port}")
  //  private String port; //    @Value注解来获取server端参数的值
  //
  //  @Value("${message}")
  //  private String message; //    @Value注解来获取server端参数的值
  //
  //  @RequestMapping("/test")
  //  public String from() {
  //    String s = "version：" + this.version + " port：" + this.port + " message：" + message;
  //    return s;
  //  }
}
