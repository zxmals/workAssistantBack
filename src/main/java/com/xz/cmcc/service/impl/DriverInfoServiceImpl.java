package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.DriverInfoDao;
import com.xz.cmcc.entity.DriverInfo;
import com.xz.cmcc.service.DriverInfoService;

@Service
public class DriverInfoServiceImpl implements DriverInfoService{

	@Autowired
	private DriverInfoDao driverInfoDao;
	

	@Override
	public DriverInfo getDriverInfoById(Integer driver_id) {
		// TODO Auto-generated method stub
		return driverInfoDao.queryDriverInfoById(driver_id);
	}


	@Override
	public List<DriverInfo> getDriverInfoByComputerAndOs(Integer computer_id, Integer operation_system_id) {
		// TODO Auto-generated method stub
		return driverInfoDao.queryDriverInfoByComputerAndOs(computer_id, operation_system_id);
	}

	
}
