package com.randy.backend.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtil implements ApplicationContextAware {
  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringBeanUtil.context = applicationContext;
  }

  public static Object getBean(String beanName) {
    return context.getBean(beanName);
  }

  public static <T> T getBean(Class<T> aClass) {
    return context.getBean(aClass);
  }
}
