package com.randy.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NotFoundController {
  @RequestMapping(value = "/notfound")
  public Mono<Map<String, String>> notFound() {
    Map<String, String> stringMap = new HashMap<>();
    stringMap.put("code", "404");
    stringMap.put("data", "found");
    return Mono.just(stringMap);
  }

  @RequestMapping(value = "/fallback")
  public Mono<Map<String, String>> fallback() {
    Map<String, String> stringMap = new HashMap<>();
    stringMap.put("code", "100");
    stringMap.put("data", "Service Not Available");
    return Mono.just(stringMap);
  }
}
