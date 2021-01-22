package com.xz.cmcc.service;

import java.util.List;

import com.xz.cmcc.entity.ComputerBrandInfo;

public interface ComputerBrandInfoService {

	List<ComputerBrandInfo> getComputerBrandInfo();
	
	ComputerBrandInfo getComputerBrandInfoById(Integer pc_brand_id);
}
