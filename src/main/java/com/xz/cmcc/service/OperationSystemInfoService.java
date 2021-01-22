package com.xz.cmcc.service;

import java.util.List;

import com.xz.cmcc.entity.OperationSystemInfo;


public interface OperationSystemInfoService {

	List<OperationSystemInfo> getOperationSystemInfo();
	
	OperationSystemInfo getOperationSystemInfoById(Integer operation_system_id);
}
