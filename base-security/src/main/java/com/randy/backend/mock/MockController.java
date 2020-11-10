package com.randy.backend.mock;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.User;
import com.randy.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/mock/api")
public class MockController extends MyBaseController<UserService, User> {
  private static final Logger logger = LoggerFactory.getLogger(MockController.class);

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test() throws IOException {
    ClassPathResource classPathResource = new ClassPathResource("mock/currentUser.json");
    InputStream inputStream = classPathResource.getInputStream();
    String content = readFileContent(inputStream);
    return content;
  }

  private String readFileContent(InputStream inputStream) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    StringBuffer content = new StringBuffer();
    String line;
    while ((line = reader.readLine()) != null) {
      content.append(line);
    }
    return content.toString();
  }

  @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
  public String currentUser() throws IOException {
    ClassPathResource classPathResource = new ClassPathResource("mock/currentUser.json");
    InputStream inputStream = classPathResource.getInputStream();
    String content = readFileContent(inputStream);
    return content;
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String users() throws IOException {
    ClassPathResource classPathResource = new ClassPathResource("mock/users.json");
    InputStream inputStream = classPathResource.getInputStream();
    String content = readFileContent(inputStream);
    return content;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register() {
    //    String content = "{\"age\":30,\"name\":\"Michael\",\"baby\":[\"Lucy\",\"Lily\"]}";
    String content = "{\"status\":\"ok\",\"currentAuthority\":\"user\"}";
    return content;
  }

  @RequestMapping(value = "/500", method = RequestMethod.GET)
  public String error500() {
    String content =
        "{\"timestamp\":\"1513932555104\",\"status\":\"500\",\"error\":\"error\",\"message\":\"error\",\"path\":\"/base/category/list\"}";
    return content;
  }

  @RequestMapping(value = "/404", method = RequestMethod.GET)
  public String error404() {
    String content =
        "{\"timestamp\":\"1513932643431\",\"status\":\"404\",\"error\":\"Not Found\",\"message\":\"No message available\",\"path\":\"/base/category/list/2121212\"}";
    return content;
  }

  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public String error403() {
    String content =
        "{\"timestamp\":\"1513932555104\",\"status\":\"403\",\"error\":\"Unauthorized\",\"message\":\"Unauthorized\",\"path\":\"/base/category/list\"}";
    return content;
  }

  @RequestMapping(value = "/401", method = RequestMethod.GET)
  public String error401() {
    String content =
        "{\"timestamp\":\"1513932555104\",\"status\":\"401\",\"error\":\"Unauthorized\",\"message\":\"Unauthorized\",\"path\":\"/base/category/list\"}";
    return content;
  }

  @RequestMapping(value = "/login/captcha", method = RequestMethod.GET)
  public String captcha() {
    String content = "captcha-xxx";
    return content;
  }

  @RequestMapping(value = "/auth_routes", method = RequestMethod.GET)
  public String auth_routes() {
    String content = "{\"/form/advanced-form\":{ \"authority\": \"['admin', 'user']\" }}";
    return content;
  }

  @RequestMapping(value = "/notices", method = RequestMethod.GET)
  public String notices() throws IOException {
    ClassPathResource classPathResource = new ClassPathResource("mock/notices.json");
    InputStream inputStream = classPathResource.getInputStream();
    String content = readFileContent(inputStream);
    return content;
  }
}
