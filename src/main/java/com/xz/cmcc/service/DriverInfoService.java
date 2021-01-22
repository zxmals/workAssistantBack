package com.xz.cmcc.service;

import java.util.List;

import com.xz.cmcc.entity.DriverInfo;

public interface DriverInfoService {

	List<DriverInfo> getDriverInfoByComputerAndOs(Integer computer_id,Integer operation_system_id);
	
	DriverInfo getDriverInfoById(Integer driver_id);
}
