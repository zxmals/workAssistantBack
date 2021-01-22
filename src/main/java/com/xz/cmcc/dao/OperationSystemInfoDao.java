package com.xz.cmcc.dao;

import java.util.List;

import com.xz.cmcc.entity.OperationSystemInfo;

public interface OperationSystemInfoDao {

	OperationSystemInfo queryOperationSystemInfoById(Integer operation_system_id);
	
	List<OperationSystemInfo> queryOperationSystemInfo();
}
