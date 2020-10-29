package com.randy.backend.config;

import com.randy.backend.model.User;
import com.randy.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserSecurityService implements UserDetailsService {

  @Autowired private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userService.findByAccount(name);
    /*        if (user == null) {
        throw new UsernameNotFoundException("用户名不存在");
    }
    else*/
    if (user != null) {
      Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
      if ("randy".equals(user.getAccount())) {
        grantedAuthorities.add(
            new SimpleGrantedAuthority("ROLE_admin")); // 只有xiekun这个用户才有管理员权限，这个地方必须要加ROLE_
      } else {
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_normal"));
      }
      user.setAuthorities(grantedAuthorities);
      return user;
    }
    throw new UsernameNotFoundException("用户名不存在");
  }
}
