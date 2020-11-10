package com.randy.backend.test.proxy.dynamicproxy;

public class Hello implements HelloInterface {
  @Override
  public void sayHello() {
    System.out.println("Hello Randy!");
  }
}
