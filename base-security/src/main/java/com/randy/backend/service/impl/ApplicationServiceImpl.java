package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.ApplicationMapper;
import com.randy.backend.model.Application;
import com.randy.backend.service.ApplicationService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl extends MyBaseServiceImpl<ApplicationMapper, Application>
    implements ApplicationService {}
