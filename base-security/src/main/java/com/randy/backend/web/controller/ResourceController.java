package com.randy.backend.web.controller;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.Resource;
import com.randy.backend.service.ResourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController extends MyBaseController<ResourceService, Resource> {}
