package com.randy.backend.cloud.hystrix;

import com.randy.backend.cloud.feign.MyFeignClient;
import org.springframework.stereotype.Component;

@Component
public class HelloHystrix implements MyFeignClient {
  @Override
  public String hello() {
    return "接口调用出现错误！";
  }
}
