package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.SoftWearTypeInfoDao;
import com.xz.cmcc.entity.SoftWearTypeInfo;
import com.xz.cmcc.service.SoftWearTypeInfoService;

@Service
public class SoftWearTypeInfoServiceImpl implements SoftWearTypeInfoService{

	@Autowired
	private SoftWearTypeInfoDao softWearTypeInfoDao;
	
	@Override
	public SoftWearTypeInfo getSoftWearTypeById(Integer softwear_type_id) {
		// TODO Auto-generated method stub
		return softWearTypeInfoDao.querySoftWearTypeInfoById(softwear_type_id);
	}

	@Override
	public List<SoftWearTypeInfo> getSoftWearTypeInfo() {
		// TODO Auto-generated method stub
		return softWearTypeInfoDao.querySoftWearTypeInfo();
	}

}
