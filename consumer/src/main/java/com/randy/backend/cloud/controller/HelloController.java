package com.randy.backend.cloud.controller;

import com.randy.backend.cloud.feign.MyFeignClient3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

  @Autowired private RestTemplate restTemplate;
  @Autowired private MyFeignClient3 myFeignClient;

  @GetMapping(value = "/hello-rest/{str}")
  public String rest(@PathVariable String str) {
    return restTemplate.getForObject("http://service-provider/hello/" + str, String.class);
  }

  @GetMapping(value = "/hello-feign/{str}")
  public String feign(@PathVariable String str) {
    return myFeignClient.echo(str);
  }
}
