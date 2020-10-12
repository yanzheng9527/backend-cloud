package com.randy.backend.cloud.controller;

import com.randy.backend.cloud.feign.MyFeignClient;
import com.randy.backend.cloud.feign.MyFeignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

  @Autowired MyFeignClient myFeignClient;
  @Autowired MyFeignClient2 myFeignClient2;

  @GetMapping("/hello")
  public String index() {
    return myFeignClient.hello();
  }

  @GetMapping("/hello2")
  public String index2() {
    return myFeignClient2.hello();
  }
}
