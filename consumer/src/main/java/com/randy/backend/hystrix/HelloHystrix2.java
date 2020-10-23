package com.randy.backend.hystrix;

import com.randy.backend.feign.MyFeignClient2;
import org.springframework.stereotype.Component;

@Component
public class HelloHystrix2 implements MyFeignClient2 {
  @Override
  public String hello() {
    return "接口调用出现错误！";
  }
}
