package com.randy.backend.web.controller;

import com.randy.backend.common.BaseController;
import com.randy.backend.model.Location;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController extends BaseController<Location> {}
