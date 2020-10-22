package com.randy.backend.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

  @RequestMapping(value = "/toFront", method = RequestMethod.GET)
  public void toFront(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.sendRedirect("http://localhost:8080");
  }
}
