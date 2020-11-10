package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.ResourceMapper;
import com.randy.backend.model.Resource;
import com.randy.backend.service.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl extends MyBaseServiceImpl<ResourceMapper, Resource>
    implements ResourceService {}
