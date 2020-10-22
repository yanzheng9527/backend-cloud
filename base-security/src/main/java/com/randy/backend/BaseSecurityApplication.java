package com.randy.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.randy.backend.dao.mapper", "com.randy.backend.test.dao"})
public class BaseSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseSecurityApplication.class, args);
	}

}
