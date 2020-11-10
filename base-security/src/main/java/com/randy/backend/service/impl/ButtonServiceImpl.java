package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.ButtonMapper;
import com.randy.backend.model.Button;
import com.randy.backend.service.ButtonService;
import org.springframework.stereotype.Service;

@Service
public class ButtonServiceImpl extends MyBaseServiceImpl<ButtonMapper, Button>
    implements ButtonService {}
