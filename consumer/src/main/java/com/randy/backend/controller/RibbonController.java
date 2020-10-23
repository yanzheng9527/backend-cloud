package com.randy.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {
  // 添加了Ribbon后，会使用Ribbon配置的负载均衡策略。
  @Autowired private LoadBalancerClient loadBalancerClient;
  @Autowired private RestTemplate restTemplate;

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

  @GetMapping("/hello")
  public String hello() {
    return restTemplate.getForObject("http://providertest/" + "hello", String.class);
  }

  @GetMapping("/LoadInstance")
  public String LoadInstance() {
    /* *
     * restTemplate.getForObject()与loadBalancerClient.choose不能放在一个方法中，因为restTemplate.getForObject()包含了choose方法
     *
     */
    ServiceInstance serviceInstance = loadBalancerClient.choose("providertest");
    return serviceInstance.toString();
  }
}
