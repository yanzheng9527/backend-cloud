package com.randy.backend.config;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 当调用的是方法时
    if (handler instanceof HandlerMethod) {
      Permission permission = ((HandlerMethod) handler).getMethodAnnotation(Permission.class);
      // 没有权限注解就不验证权限
      if (permission == null) {
        return true;
      } else {
        try {
          // 存在权限注解就进行验证权限
          String header = request.getHeader("Authorization");
          String token = StrUtil.subAfter(header, "bearer ", false);
          Claims claims =
              Jwts.parser()
                  .setSigningKey("test_key".getBytes(StandardCharsets.UTF_8))
                  .parseClaimsJws(token)
                  .getBody();
          AuthInfo authInfo = new AuthInfo();
          String userName = (String) claims.get("user_name");
          authInfo.setAccount(userName);
          List<String> authorities = (List) claims.get("authorities");
          authInfo.setAuthorities(authorities);
          AuthUtils.set(authInfo);
        } catch (Exception e) {
          // 返回权限验证失败信息
          response.setCharacterEncoding("utf-8");
          response.setContentType("application/json; charset=utf-8");
          response.setStatus(401);
          PrintWriter writer = response.getWriter();
          Map<String, String> map = new HashMap<>();
          map.put("code", "401");
          map.put("message", "权限验证失败!");
          ObjectMapper mapper = new ObjectMapper();
          writer.write(mapper.writeValueAsString(map));
          return false;
        }
      }
    }

    return true;
  }

  public void afterCompletion(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      @Nullable Exception ex)
      throws Exception {

    AuthUtils.remove();
  }
}
