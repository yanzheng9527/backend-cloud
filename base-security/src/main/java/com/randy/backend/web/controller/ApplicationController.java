package com.randy.backend.web.controller;

import com.randy.backend.common.MyBaseController;
import com.randy.backend.model.Application;
import com.randy.backend.service.ApplicationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController extends MyBaseController<ApplicationService, Application> {}
