package com.randy.backend.web.controller;

import cn.hutool.core.util.StrUtil;
import com.randy.backend.common.DataType;
import com.randy.backend.common.MyBaseController;
import com.randy.backend.common.MyPage;
import com.randy.backend.common.SqlParam;
import com.randy.backend.enums.SqlOperator;
import com.randy.backend.model.Dto;
import com.randy.backend.model.Permission;
import com.randy.backend.model.User;
import com.randy.backend.service.UserService;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController extends MyBaseController<UserService, User> {
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String test() {
    logger.debug("-----------------log debug-------------------");
    //    throw new BusinessException("业务处理异常");
    return "success";
  }

  @RequestMapping(value = "/batchInsert", method = RequestMethod.GET)
  public String batchInsert() {
    ArrayList<User> users = new ArrayList<>();
    for (int i = 0; i < 500000; i++) {
      User user = new User();
      user.setId(String.valueOf(i));
      user.setAccount(String.valueOf(i));
      user.setPassword("pwd" + i);
    }
    myBaseService.saveBatch(users);
    return "success";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public Dto login(@RequestBody User user) {
    //    Subject subject = SecurityUtils.getSubject();
    //    UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),
    // user.getPassword());
    //    User loginUser = null;
    //    try {
    //      // 登录，即身份验证
    //      subject.login(token);
    //      loginUser = (User) subject.getPrincipal();
    //      logger.debug("loginUser:" + loginUser);
    //      logger.debug("hasRole:" + subject.hasRole("普通用户"));
    //    } catch (AuthenticationException e) {
    //      // 身份验证失败
    //      throw new BusinessException("用户名或密码错误！");
    //    }
    //    return apiHandler.responseDto(loginUser);
    return apiHandler.responseDto("");
  }

  //  @RequestMapping(value = "/pagingAll", method = RequestMethod.GET)
  //  public Dto pagingAll(int currentPage, int pageSize) {
  //    PageInfo<T> pageInfo = service.pagingAll(currentPage, pageSize);
  //    return apiHandler.responseDto(pageInfo);
  //  }

  //  @RequestMapping(value = "/query", method = RequestMethod.GET)
  //  public Dto query(
  //      String account,
  //      String phone,
  //      @RequestParam(required = false, defaultValue = "1") int currentPage,
  //      @RequestParam(required = false, defaultValue = "10") int pageSize) {
  //    //    PageInfo<User> pageInfo = userService.query(account, phone, currentPage, pageSize);
  //    SqlParam sqlParam1 = new SqlParam("account", DataType.STRING, account, SqlOperator.LIKE);
  //    SqlParam sqlParam2 = new SqlParam("phone", DataType.STRING, phone, SqlOperator.LIKE);
  //    List<SqlParam> sqlParams = new ArrayList<>();
  //    sqlParams.add(sqlParam1);
  //    sqlParams.add(sqlParam2);
  //    PageInfo<User> pageInfo = userService.pagingQuery(sqlParams, currentPage, pageSize,
  // User.class);
  //    return apiHandler.responseDto(pageInfo);
  //  }

  @RequestMapping(value = "/query", method = RequestMethod.GET)
  public Dto query(
      String account,
      String phone,
      @RequestParam(required = false, defaultValue = "1") int currentPage,
      @RequestParam(required = false, defaultValue = "10") int pageSize) {
    SqlParam sqlParam1 = new SqlParam("account", DataType.STRING, account, SqlOperator.LIKE);
    SqlParam sqlParam2 = new SqlParam("phone", DataType.STRING, phone, SqlOperator.LIKE);
    List<SqlParam> sqlParams = new ArrayList<>();
    sqlParams.add(sqlParam1);
    sqlParams.add(sqlParam2);
    MyPage<User> userPage = myBaseService.pagingQuery(sqlParams, currentPage, pageSize);
    return apiHandler.responseDto(userPage);
  }

  @RequestMapping(value = "/customPagingQuery", method = RequestMethod.GET)
  public Dto customPagingQuery(
      String account,
      String phone,
      @RequestParam(required = false, defaultValue = "1") int currentPage,
      @RequestParam(required = false, defaultValue = "10") int pageSize) {
    MyPage<User> page = new MyPage<>(currentPage, pageSize);
    MyPage<User> userPage = myBaseService.customPagingQuery(page, account, phone);
    return apiHandler.responseDto(userPage);
  }

  @RequestMapping(value = "/loginTest", method = RequestMethod.POST)
  public Dto loginTest(@RequestBody User user) {
    String account = user.getAccount();
    String password = user.getPassword();
    if (account.equalsIgnoreCase("admin") && password.equalsIgnoreCase("ant.design")) {
      Permission permission1 = new Permission();
      permission1.setCode("admin");
      Set<Permission> perms = new HashSet<>();
      perms.add(permission1);
      User userinfo = new User();
      userinfo.setPerms(perms);
      //      userinfo.setPermCodes("admin");
      //      userinfo.setPermCodes(new String[] {"admin"});
      Set<String> permCodes = new HashSet<>();
      permCodes.add("admin");
      userinfo.setPermCodes(permCodes);
      return apiHandler.responseDto(userinfo);
    } else if (account.equalsIgnoreCase("user") && password.equalsIgnoreCase("ant.design")) {
      Permission permission1 = new Permission();
      permission1.setCode("user");
      Set<Permission> perms = new HashSet<>();
      perms.add(permission1);
      User userinfo = new User();
      userinfo.setPerms(perms);
      //      String[] permCodes = {"user", "admin"};
      Set<String> permCodes = new HashSet<>();
      permCodes.add("user");
      permCodes.add("admin");
      userinfo.setPermCodes(permCodes);
      return apiHandler.responseDto(userinfo);
    } else {
      Dto dto = new Dto();
      dto.setCode(401);
      dto.setMessage("登录失败");
      return dto;
    }
  }

  @RequestMapping(value = "/aopTest", method = RequestMethod.GET)
  //  @Dao("controller test")
  public List<User> aopTest() {
    List<User> users = myBaseService.aopTest();
    System.out.println("userService:" + myBaseService.getClass());
    //    return apiHandler.responseDto(users);
    return users;
  }

  @RequestMapping(value = "/aopTest2", method = RequestMethod.GET)
  public List<User> aopTest2() {
    List<User> users = myBaseService.aopTest2();
    System.out.println("userService:" + myBaseService.getClass());
    //    return apiHandler.responseDto(users);
    return users;
  }

  @GetMapping("/register")
  public ResponseEntity<Dto> register(User user) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    user.setPassword(encoder.encode(user.getPassword()));
    return ResponseEntity.ok(new Dto(myBaseService.save(user)));
  }

  //  @GetMapping("/member")
  //  public Principal user(Principal member) {
  //    /** 获取当前用户信息 */
  //    return member;
  //  }

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
