package com.randy.backend.service.impl;

import com.randy.backend.common.MyBaseServiceImpl;
import com.randy.backend.dao.mapper.LocationMapper;
import com.randy.backend.model.Location;
import com.randy.backend.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends MyBaseServiceImpl<LocationMapper, Location>
    implements LocationService {}
