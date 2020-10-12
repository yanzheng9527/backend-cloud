package com.randy.backend.cloud.hystrix;

import com.randy.backend.cloud.feign.MyFeignClient2;
import org.springframework.stereotype.Component;

@Component
public class HelloHystrix2 implements MyFeignClient2 {
  @Override
  public String hello() {
    return "接口调用出现错误！";
  }
}
