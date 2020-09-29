package com.randy.backend.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "providertest", configuration = RibbonClientConfiguration.class)
public class RibbonConfig {
  /*
   *Ribbon的规则
   */
  @Bean
  public IRule iRule() {
    return new RandomRule();
  }
}
