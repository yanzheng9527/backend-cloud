package com.randy.backend.controller;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/test")
public class TestController {
  @PreAuthorize("hasAuthority('ROLE_admin')")
  @GetMapping("/testauthority")
  public String testauthority() {
    return "admin权限可以查看";
  }

  @PreAuthorize("hasRole('normal')")
  @GetMapping("/testrole")
  public String testrole() {
    return "角色ROLE_normal可以查看";
  }

  @GetMapping("/getCurrentUser")
  public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {
    String header = request.getHeader("Authorization");
    String token = StrUtil.subAfter(header, "bearer ", false);
    return Jwts.parser()
        .setSigningKey("test_key".getBytes(StandardCharsets.UTF_8))
        .parseClaimsJws(token)
        .getBody();
  }
}
