package com.randy.backend.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspTestController {
  @RequestMapping("/index")
  public String index() {
    return "index";
  }
}
