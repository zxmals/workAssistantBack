package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.OperationSystemInfoDao;
import com.xz.cmcc.entity.OperationSystemInfo;
import com.xz.cmcc.service.OperationSystemInfoService;

@Service
public class OpeartionSystemInfoServiceImpl implements OperationSystemInfoService{

	@Autowired
	private OperationSystemInfoDao osInfoDao;
	
	@Override
	public List<OperationSystemInfo> getOperationSystemInfo() {
		// TODO Auto-generated method stub
		return osInfoDao.queryOperationSystemInfo();
	}

	@Override
	public OperationSystemInfo getOperationSystemInfoById(Integer operation_system_id) {
		// TODO Auto-generated method stub
		return osInfoDao.queryOperationSystemInfoById(operation_system_id);
	}

}
