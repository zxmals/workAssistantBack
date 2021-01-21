package com.xz.cmcc.dao;

import java.util.List;

import com.xz.cmcc.entity.DriverInfo;

public interface DriverInfoDao {
	
	List<DriverInfo> queryDriverInfoByComputerAndOs(Integer computer_id,Integer operation_system_id);
	
	DriverInfo queryDriverInfoById(Integer driver_id);
}
