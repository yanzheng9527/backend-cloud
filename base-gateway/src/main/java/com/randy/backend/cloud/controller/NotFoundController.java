package com.randy.backend.cloud.controller;

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
}
