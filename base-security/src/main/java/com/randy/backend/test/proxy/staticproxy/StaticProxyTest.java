package com.randy.backend.test.proxy.staticproxy;

public class StaticProxyTest {
  public static void main(String[] args) {
    HelloInterface helloProxy = new HelloProxy();
    helloProxy.sayHello();
  }
}
