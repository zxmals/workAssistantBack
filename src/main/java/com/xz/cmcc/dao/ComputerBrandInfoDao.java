package com.xz.cmcc.dao;

import java.util.List;

import com.xz.cmcc.entity.ComputerBrandInfo;

public interface ComputerBrandInfoDao {

	ComputerBrandInfo queryComputerBrandInfoById(Integer pc_brand_id);
	
	List<ComputerBrandInfo> queryComputerBrandInfo();
}
