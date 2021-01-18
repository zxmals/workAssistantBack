package com.xz.cmcc.service;

import com.xz.cmcc.entity.userProperty;

public interface userPropertyService {

	userProperty getUserPropertyByMacAddress(String macAddress);
	
	userProperty getUserPropertyByIpAddress(String ipAddress);
	
}
