package com.randy.backend.cloud.feign;

import com.randy.backend.cloud.config.FeignConfiguration;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    contextId = "feignClient",
    name = "service-provider",
    configuration = FeignConfiguration.class)
public interface MyFeignClient {
  /** Spring MVC注解修改为Feign自带的注解； 使用feign自带的注解@RequestLine； */
  @RequestLine("GET /hello")
  public String hello();
}
