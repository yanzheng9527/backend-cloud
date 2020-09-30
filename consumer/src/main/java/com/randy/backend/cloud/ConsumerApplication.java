package com.randy.backend.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 从Spring Cloud Edgware开始，@EnableDiscoveryClient 或@EnableEurekaClient 可省略。
// @EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication {
  /** @LoadBalanced注解，表示开启客户端负载均衡，Ribbon使用。 */
  @LoadBalanced
  /** 实例化RestTemplate */
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }
}
