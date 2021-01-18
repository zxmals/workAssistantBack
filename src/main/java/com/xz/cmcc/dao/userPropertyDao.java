package com.xz.cmcc.dao;

import com.xz.cmcc.entity.userProperty;

public interface userPropertyDao {

	userProperty queryUserPropertyByMacAddress(String macAddress);
	
	userProperty queryUserPropertyByIpAddress(String ipAddress);
}
