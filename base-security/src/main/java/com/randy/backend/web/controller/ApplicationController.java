package com.randy.backend.web.controller;

import com.randy.backend.common.BaseController;
import com.randy.backend.model.Application;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController extends BaseController<Application> {}
