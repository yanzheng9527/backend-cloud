package com.randy.backend.config;

import com.randy.backend.config.jwt.JwtTokenEnhancer;
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
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired private PasswordEncoder passwordEncoder;
  /** Spring Boot版本2.0.*无法自动注入AuthenticationManager,需要重写authenticationManagerBean */
  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private UserSecurityService userSecurityService;

  @Autowired
  //  @Qualifier("redisTokenStore")
  @Qualifier("jwtTokenStore")
  private TokenStore tokenStore;

  @Autowired private JwtAccessTokenConverter jwtAccessTokenConverter;
  @Autowired private JwtTokenEnhancer jwtTokenEnhancer;

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    //    endpoints
    //        .authenticationManager(authenticationManager) //
    // 使用oauth2的密码模式时需要配置authenticationManager
    //        .userDetailsService(userSecurityService)
    //        .tokenStore(tokenStore);

    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
    List<TokenEnhancer> delegates = new ArrayList<>();
    delegates.add(jwtTokenEnhancer); // 配置JWT的内容增强器
    delegates.add(jwtAccessTokenConverter);
    enhancerChain.setTokenEnhancers(delegates);
    endpoints
        .authenticationManager(authenticationManager)
        .userDetailsService(userSecurityService)
        .tokenStore(tokenStore) // 配置令牌存储策略
        .accessTokenConverter(jwtAccessTokenConverter)
        .tokenEnhancer(enhancerChain);
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
        .accessTokenValiditySeconds(3600)
        .refreshTokenValiditySeconds(864000)
        .redirectUris("http://www.baidu.com")
        .autoApprove(true) // 自动授权配置
        .scopes("all")
        // 获取的token里有refresh_token
        .authorizedGrantTypes(
            "password", "refresh_token", "authorization_code", "client_credentials");
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }
}
