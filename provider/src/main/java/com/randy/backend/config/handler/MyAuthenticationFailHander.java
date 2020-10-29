package com.randy.backend.config.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("myAuthenticationFailHander")
public class MyAuthenticationFailHander extends SimpleUrlAuthenticationFailureHandler {

  // 用户名密码错误执行
  @Override
  public void onAuthenticationFailure(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      AuthenticationException e)
      throws IOException {
    httpServletRequest.setCharacterEncoding("UTF-8");
    // 获得用户名密码
    String username = httpServletRequest.getParameter("name");
    String password = httpServletRequest.getParameter("password");

    httpServletResponse.setContentType("application/json;charset=utf-8");
    PrintWriter out = httpServletResponse.getWriter();
    out.write("{\"status\":\"error\",\"message\":\"用户名或密码错误\"}");
    out.flush();
    out.close();
  }
}
