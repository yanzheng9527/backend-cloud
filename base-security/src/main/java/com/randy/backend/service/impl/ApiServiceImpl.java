package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.ApiMapper;
import com.randy.backend.model.Api;
import com.randy.backend.service.ApiService;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl extends MyBaseServiceImpl<ApiMapper, Api> implements ApiService {}
