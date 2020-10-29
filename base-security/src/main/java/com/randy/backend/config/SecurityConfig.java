package com.randy.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 指定为配置类
@EnableWebSecurity // 指定为Spring Security配置类
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // 使用 BCrypt 加密
  }

  @Bean
  UserDetailsService UserSecurityService() {
    return new UserSecurityService();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(UserSecurityService()).passwordEncoder(new BCryptPasswordEncoder() {});
  }

  /** 重写authenticationManagerBean */
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/user/register")
        .permitAll()
        .antMatchers("/actuator/**")
        .permitAll()
        .antMatchers("/oauth/**")
        .permitAll();
    // 由于所有接口默认会被资源服务器保护的，所以这个地方我们需要放行注册接口和监控检查接口
  }
}
