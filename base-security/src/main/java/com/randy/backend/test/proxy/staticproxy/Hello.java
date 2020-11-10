package com.randy.backend.test.proxy.staticproxy;

public class Hello implements HelloInterface {
  @Override
  public void sayHello() {
    System.out.println("Hello Randy!");
  }
}
