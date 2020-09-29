package com.randy.backend.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TestController {
  @Autowired private LoadBalancerClient loadBalancerClient;

  @GetMapping("/test")
  public String test() {
    // 注意：loadBalancerClient可以不用consul，只使用本地配置，但是使用consul后，会用consul中的ip替换本地使用的localhost！
    ServiceInstance serviceInstance = loadBalancerClient.choose("providertest");
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
    String str =
        serviceInstance.getHost() + ":" + serviceInstance.getPort() + "@" + sdf.format(date);
    return str;
  }
}
