package com.xz.cmcc.service;

import java.util.List;

import com.xz.cmcc.entity.ComputerInfo;

public interface ComputerInfoService {

	List<ComputerInfo> getComputerInfo();
	
	ComputerInfo getComputerInfoById(Integer computer_id);
	
	ComputerInfo getComputerInfoByBrandAndModel(Integer pc_brand_id,Integer pc_model_id);
}
