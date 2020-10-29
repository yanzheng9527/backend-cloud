package com.randy.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired private PasswordEncoder passwordEncoder;
  /** Spring Boot版本2.0.*无法自动注入AuthenticationManager,需要重写authenticationManagerBean */
  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private UserSecurityService userSecurityService;

  @Autowired
  @Qualifier("redisTokenStore")
  private TokenStore tokenStore;

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    endpoints
        .authenticationManager(authenticationManager) // 使用oauth2的密码模式时需要配置authenticationManager
        .userDetailsService(userSecurityService)
        .tokenStore(tokenStore);
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients
        .inMemory()
        .withClient("app")
        // Spring Boot1.x版本中不需要加密的，但2.x版本需要加密
        .secret(passwordEncoder.encode("123456"))
        // 这样写的话，获取的token里不会有refresh_token
        .authorizedGrantTypes("password")
        .scopes("all")
        // Token有效时间
        .accessTokenValiditySeconds(36000)
        .and()
        .withClient("web")
        .secret(passwordEncoder.encode("123456"))
        // 获取的token里有refresh_token
        .authorizedGrantTypes(
            "password", "refresh_token", "authorization_code", "client_credentials")
        .scopes("all")
        .redirectUris("http://www.phei.com.cn")
        .accessTokenValiditySeconds(36000);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }
}
