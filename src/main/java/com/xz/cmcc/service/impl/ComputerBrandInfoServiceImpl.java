package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.ComputerBrandInfoDao;
import com.xz.cmcc.entity.ComputerBrandInfo;
import com.xz.cmcc.service.ComputerBrandInfoService;

@Service
public class ComputerBrandInfoServiceImpl implements ComputerBrandInfoService{

	@Autowired
	private ComputerBrandInfoDao cbInfoDao;
	
	@Override
	public List<ComputerBrandInfo> getComputerBrandInfo() {
		// TODO Auto-generated method stub
		return cbInfoDao.queryComputerBrandInfo();
	}

	@Override
	public ComputerBrandInfo getComputerBrandInfoById(Integer pc_brand_id) {
		// TODO Auto-generated method stub
		return cbInfoDao.queryComputerBrandInfoById(pc_brand_id);
	}

	
}
