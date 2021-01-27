package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.AppTypeInfoDao;
import com.xz.cmcc.entity.AppTypeInfo;
import com.xz.cmcc.service.AppTypeInfoService;

@Service
public class AppTypeInfoServiceImpl implements AppTypeInfoService{

	@Autowired
	private AppTypeInfoDao appTypeInfoDao;
	
	@Override
	public List<AppTypeInfo> getAppTypeInfo() {
		// TODO Auto-generated method stub
		return appTypeInfoDao.queryAppTypeInfo();
	}

	@Override
	public AppTypeInfo getAppTypeInfoById(Integer app_type_id) {
		// TODO Auto-generated method stub
		return appTypeInfoDao.queryAppTypeInfoById(app_type_id);
	}

}
