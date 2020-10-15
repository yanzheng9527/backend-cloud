package com.randy.backend.cloud.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-provider")
public interface MyFeignClient3 {
  //  SpringMVC的写法：
  //  @GetMapping(value = "/hello/{str}")
  //  public String echo(@PathVariable("str") String str);

  //  Feign的写法：
  @RequestLine("GET /hello/{str}")
  public String echo(@Param("str") String str);
}
