package com.randy.backend.test;

public class Test {
  public static void main(String[] args) {
    String str =
        "http://localhost:8090/yummy-map/user/test?fromURL=http%3A%2F%2Flocalhost%3A8080%2F";
    String str2 = str.substring(0, str.indexOf("?"));
    System.out.println(str2);
  }
}
