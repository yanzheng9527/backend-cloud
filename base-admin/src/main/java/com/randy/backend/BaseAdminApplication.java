package com.randy.backend;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class BaseAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(BaseAdminApplication.class, args);
  }
}
