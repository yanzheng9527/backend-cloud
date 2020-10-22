package com.randy.backend.web.controller;

import com.randy.backend.common.BaseController;
import com.randy.backend.model.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController<Resource> {}
