package com.randy.backend.test;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class ScheduleTest {
  //  @Scheduled(initialDelay = 1000, fixedDelay = 1000)
  public void test() {
    System.out.println("schedule test");
  }
}
