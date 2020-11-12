package com.randy.backend.config;

import java.util.ArrayList;
import java.util.List;

public class AuthInfo {
  private String account;
  private List<String> authorities = new ArrayList<>();

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public List<String> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<String> authorities) {
    this.authorities = authorities;
  }
}
