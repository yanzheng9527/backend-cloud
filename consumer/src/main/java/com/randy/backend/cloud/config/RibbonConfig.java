package com.randy.backend.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @RibbonClient(name = "service-provider", configuration = RibbonConfig.class)
public class RibbonConfig {
  /*
   *Ribbon的规则
   */
  @Bean
  public IRule iRule() {
    // 随机负载均衡策略
    return new RandomRule();
    // 轮询负载均衡策略
    //    return new RoundRobinRule();
  }

  //  @Bean
  //  public IPing ribbonPing() {
  //    return new PingUrl(false, "/actuator/health");
  //  }
}
