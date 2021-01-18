package com.xz.cmcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.userPropertyDao;
import com.xz.cmcc.entity.userProperty;
import com.xz.cmcc.service.userPropertyService;

@Service
public class userPropertyServiceImpl implements userPropertyService{

	@Autowired
	private userPropertyDao userPropDao;

	@Override
	public userProperty getUserPropertyByMacAddress(String macAddress) {
		// TODO Auto-generated method stub		
		return userPropDao.queryUserPropertyByMacAddress(macAddress);
	}

	@Override
	public userProperty getUserPropertyByIpAddress(String ipAddress) {
		// TODO Auto-generated method stub
		return userPropDao.queryUserPropertyByIpAddress(ipAddress);
	}
}
