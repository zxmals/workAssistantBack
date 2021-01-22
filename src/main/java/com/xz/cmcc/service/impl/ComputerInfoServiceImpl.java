package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.ComputerInfoDao;
import com.xz.cmcc.entity.ComputerInfo;
import com.xz.cmcc.service.ComputerInfoService;

@Service
public class ComputerInfoServiceImpl implements ComputerInfoService{

	@Autowired
	private ComputerInfoDao computerInfoDao;
	
	@Override
	public List<ComputerInfo> getComputerInfo() {
		// TODO Auto-generated method stub
		return computerInfoDao.queryComputerInfo();
	}

	@Override
	public ComputerInfo getComputerInfoById(Integer computer_id) {
		// TODO Auto-generated method stub
		return computerInfoDao.queryComputerInfoById(computer_id);
	}

	@Override
	public ComputerInfo getComputerInfoByBrandAndModel(Integer pc_brand_id, Integer pc_model_id) {
		// TODO Auto-generated method stub
		return computerInfoDao.queryComputerInfoByBrandAndModel(pc_brand_id, pc_model_id);
	}

}
