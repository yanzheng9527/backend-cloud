package com.randy.backend.test.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

  //  @Pointcut("execution(* com.randy.backend.web.controller.UserController.aopTest(..))")
  //  public void logAspect() {}
  //
  //  @Before("logAspect()")
  //  public void beforeLogAspect() {
  //    System.out.println("--------beforeLogAspect----------");
  //  }

  @Pointcut("execution(* com.randy.backend.service.AuthorizationService.*(..))")
  public void interfaceAspect() {}

  @Before("interfaceAspect()")
  public void beforeInterfaceAspect() {
    System.out.println("--------beforeInterfaceAspect----------");
  }

  //  @Pointcut(value = "@annotation(log)", argNames = "log")
  //  public void logAnnotation(Log log) {}
  //
  //  @Before("logAnnotation(log)")
  //  public void beforeLogAnnotation(Log log) {
  //    System.out.println("--------beforeLogAnnotation----------");
  //    System.out.println("log value:" + log.value());
  //  }

  @Pointcut("execution(* com.randy.backend.test.web.service.TestService.*(..))")
  public void interfaceAspect2() {}

  @Before("interfaceAspect2()")
  public void beforeInterfaceAspect2() {
    System.out.println("--------beforeInterfaceAspect2----------");
  }

  //  @Pointcut(value = "@annotation(log)", argNames = "log")
  //  public void logAnnotation(Log log) {}
  //
  //  @Before("logAnnotation(log)")
  //  public void beforeLogAnnotation(Log log) {
  //    System.out.println("--------beforeLogAnnotation----------");
  //    System.out.println("log value:" + log.value());
  //  }
}
