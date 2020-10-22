package com.randy.backend.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CrossDomainFilter implements Filter {
  private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
  private int crossMaxAge = 1800;
  private List<String> allowOriginDomains;

  public void setCrossMaxAge(int crossMaxAge) {
    this.crossMaxAge = crossMaxAge;
  }

  public void setAllowOriginDomains(List<String> allowOriginDomains) {
    this.allowOriginDomains = allowOriginDomains;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;
    String origin = ((HttpServletRequest) req).getHeader("Origin");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", String.valueOf(crossMaxAge));
    response.setHeader(
        "Access-Control-Allow-Headers",
        "Origin, X-Requested-With, Content-Type, Accept, X-Auth-Token");
    response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
    response.setHeader("Access-Control-Allow-Credentials", "true");
    // 让Ajax的OPTION预请求通过
    if ("OPTIONS".equals(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
      return;
    }

    //    // 配置可信IP范围后使用
    //    //    String origin = ((HttpServletRequest) req).getHeader("Origin");
    //    //    if (origin != null && !"*".equals(response.getHeader(ACCESS_CONTROL_ALLOW_ORIGIN)))
    // {
    //    //      setAllowDomain(response, origin);
    //    //    }
    chain.doFilter(req, resp);
  }

  private void setAllowDomain(HttpServletResponse response, String origin) {
    if (allowOriginDomains.contains(origin)) {
      response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
    }
  }

  @Override
  public void destroy() {}
}
