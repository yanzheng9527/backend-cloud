package com.randy.backend.service.impl;

import com.randy.backend.common.BaseServiceImpl;
import com.randy.backend.model.Application;
import com.randy.backend.service.ApplicationService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl extends BaseServiceImpl<Application>
    implements ApplicationService {}
