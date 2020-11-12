package com.randy.backend.controller;

import com.randy.backend.config.AuthInfo;
import com.randy.backend.config.AuthUtils;
import com.randy.backend.config.Permission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {
  //  @PreAuthorize("hasAuthority('ROLE_admin')")
  @GetMapping("/testauthority")
  public String testauthority() {
    return "admin权限可以查看";
  }
  //
  //  @PreAuthorize("hasRole('normal')")
  @GetMapping("/testrole")
  public String testrole() {
    return "角色ROLE_normal可以查看";
  }
  //
  //  @GetMapping("/getCurrentUser")
  //  public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {
  //    String header = request.getHeader("Authorization");
  //    String token = StrUtil.subAfter(header, "bearer ", false);
  //    return Jwts.parser()
  //        .setSigningKey("test_key".getBytes(StandardCharsets.UTF_8))
  //        .parseClaimsJws(token)
  //        .getBody();
  //  }

  //  @GetMapping("/getCurrentUser2")
  //  public Object getCurrentUser2(Authentication authentication, HttpServletRequest request) {
  //    return authentication;
  //  }
  //
  //  @GetMapping("/getCurrentUser3")
  //  public Object getCurrentUser3(HttpServletRequest request) {
  //    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
  //    return authentication;
  //  }

  @GetMapping("/perm")
  @Permission(code = "123", desc = "测试")
  public Object permTest(HttpServletRequest request) {
    AuthInfo authInfo = AuthUtils.get();
    System.out.println("authInfo:" + authInfo);
    return authInfo;
  }
}
