package com.randy.backend.test.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class DataSourceAspect {

  @Bean
  public Advisor dataSourceAdvisor() {
    Pointcut pointcut = new AnnotationMatchingPointcut(Dao.class, true);
    Advice advice = new MethodAroundAdvice();

    return new DefaultPointcutAdvisor(pointcut, advice);
  }

  private static class MethodAroundAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
      //      log.info("before {} called", method.getName());
      System.out.println("before {} called" + method.getName());
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
        throws Throwable {
      //      log.info("after {} called", method.getName());
      System.out.println("after {} called" + method.getName());
    }
  }
}
