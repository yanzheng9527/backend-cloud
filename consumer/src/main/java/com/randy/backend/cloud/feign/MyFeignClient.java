package com.randy.backend.cloud.feign;

import com.randy.backend.cloud.config.FeignConfiguration;
import com.randy.backend.cloud.hystrix.HelloHystrix;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;

// MyFeignClient和HelloHystrix都是MyFeignClient类型的bean，@Autowired将不知道注入哪个bean，所以这里需要设置@Primary！
@Primary
@FeignClient(
    contextId = "feignClient",
    name = "service-provider",
    configuration = FeignConfiguration.class,
    fallback = HelloHystrix.class)
public interface MyFeignClient {
  /** Spring MVC注解修改为Feign自带的注解； 使用feign自带的注解@RequestLine； */
  @RequestLine("GET /hello")
  public String hello();
}
