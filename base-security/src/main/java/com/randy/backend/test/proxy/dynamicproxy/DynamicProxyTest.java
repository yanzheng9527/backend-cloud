package com.randy.backend.test.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
  public static void main(String[] args) {
    //    System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    HelloInterface hello = new Hello();
    InvocationHandler handler = new ProxyHandler(hello);
    HelloInterface proxyHello =
        (HelloInterface)
            Proxy.newProxyInstance(
                hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
    proxyHello.sayHello();
  }
}
