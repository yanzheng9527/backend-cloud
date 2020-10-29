package com.randy.backend.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
