package com.xz.cmcc.dao;

import java.util.List;

import com.xz.cmcc.entity.ComputerInfo;

public interface ComputerInfoDao {
	
	List<ComputerInfo> queryComputerInfo();

	ComputerInfo queryComputerInfoById(Integer computer_id);
	
	ComputerInfo queryComputerInfoByBrandAndModel(Integer pc_brand_id,Integer pc_model_id);
}
