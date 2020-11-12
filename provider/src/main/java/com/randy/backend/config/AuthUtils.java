package com.randy.backend.config;

public class AuthUtils {
  public static final ThreadLocal<AuthInfo> threadLocal = new ThreadLocal<>();

  public static void set(AuthInfo authInfo) {
    threadLocal.set(authInfo);
  }

  public static AuthInfo get() {
    return threadLocal.get();
  }

  public static void remove() {
    threadLocal.remove();
  }
}
