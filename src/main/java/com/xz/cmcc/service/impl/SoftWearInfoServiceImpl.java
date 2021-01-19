package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.SoftWearInfoDao;
import com.xz.cmcc.entity.SoftWearInfo;
import com.xz.cmcc.service.SoftWearInfoService;

@Service
public class SoftWearInfoServiceImpl implements SoftWearInfoService{

	@Autowired
	private SoftWearInfoDao softWearInfoDao;
	
	@Override
	public List<SoftWearInfo> getSoftWearInfo() {
		// TODO Auto-generated method stub
		return softWearInfoDao.querySoftWearInfo();
	}

	@Override
	public SoftWearInfo getSoftWearInfoById(Integer softWearId) {
		// TODO Auto-generated method stub
		return softWearInfoDao.querySoftWearInfoById(softWearId);
	}
	
}
