package com.randy.backend.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  // 用户名和密码正确执行
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Authentication authentication)
      throws IOException {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal != null && principal instanceof UserDetails) {
      UserDetails user = (UserDetails) principal;
      httpServletResponse.setContentType("application/json;charset=utf-8");
      PrintWriter out = httpServletResponse.getWriter();
      out.write("{\"status\":\"ok\",\"message\":\"登录成功\"}");
      out.flush();
      out.close();
    }
  }
}
