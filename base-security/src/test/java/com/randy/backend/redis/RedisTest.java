package com.randy.backend.redis;

import com.randy.backend.BaseSecurityApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseSecurityApplication.class)
public class RedisTest {

  @Autowired StringRedisTemplate stringRedisTemplate;
  //  @Autowired RedisTemplate redisTemplate;

  @Test
  public void test1() {
    stringRedisTemplate.opsForValue().set("user", "randy123");
    String value = stringRedisTemplate.opsForValue().get("user");
    Assert.assertEquals(value, "randy123");
  }
}
