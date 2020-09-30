package com.randy.backend.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 从Spring Cloud Edgware开始，@EnableDiscoveryClient 或@EnableEurekaClient 可省略。
// @EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
// @EnableCircuitBreaker加了这个hystrix-dashboard会把断路的数量统计为failure，否则会统计成time-out！
@EnableCircuitBreaker
public class ConsumerApplication {
  /** @LoadBalanced注解，表示开启客户端负载均衡，Ribbon使用。 */
  @LoadBalanced
  /** 实例化RestTemplate */
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  /** 配置servlet 2.0的版本需要配置servlet */
  @Bean
  public ServletRegistrationBean getServlet() {
    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1);
    registrationBean.addUrlMappings("/actuator/hystrix.stream");
    registrationBean.setName("HystrixMetricsStreamServlet");
    return registrationBean;
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }
}
