package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.MenuMapper;
import com.randy.backend.model.Menu;
import com.randy.backend.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends MyBaseServiceImpl<MenuMapper, Menu> implements MenuService {}
