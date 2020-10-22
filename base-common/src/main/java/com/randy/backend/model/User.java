package com.randy.backend.model;

import java.util.HashSet;
import java.util.Set;

public class User extends Entity {
  private String account;
  private String password;
  private String phone;
  private String email;
  private Set<Role> roles = new HashSet<>(); // 用户所有角色值，用于shiro做角色权限的判断
  private Set<Permission> perms = new HashSet<>(); // 用户所有权限值，用于shiro做资源权限的判断
  //  @Transient private String permCodes;
  //  private String[] permCodes;
  private Set<String> permCodes = new HashSet<>();

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Set<Permission> getPerms() {
    return perms;
  }

  public void setPerms(Set<Permission> perms) {
    this.perms = perms;
  }

  //  public String getPermCodes() {
  //    return permCodes;
  //  }
  //
  //  public void setPermCodes(String permCodes) {
  //    this.permCodes = permCodes;
  //  }

  //  public String[] getPermCodes() {
  //    return permCodes;
  //  }
  //
  //  public void setPermCodes(String[] permCodes) {
  //    this.permCodes = permCodes;
  //  }

  public Set<String> getPermCodes() {
    return permCodes;
  }

  public void setPermCodes(Set<String> permCodes) {
    this.permCodes = permCodes;
  }
}
