package com.randy.backend.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

  /*
   * Spring Cloud Netflix默认的SpringMvcController将替换为feign.Contract.Default。
   * 用feign.Contract.Default将契约改为Feign原生的默认契约，就可以使用feign自带的注解了。
   * 设置了才能使用@RequestLine，否则只能用SpringMVC的@RequestMapping！
   */
  @Bean
  public Contract feignContract() {
    return new feign.Contract.Default();
  }

  /**
   * Description: 配置类，配置记录日志的类别。 NONE：不记录（默认）。 BASIC：只记录请求方法和URL以及响应状态码和执行时间。
   * HEADERS：记录基本信息以及请求和响应标题。 FULL：记录请求和响应的标题，正文和元数据。
   */
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
