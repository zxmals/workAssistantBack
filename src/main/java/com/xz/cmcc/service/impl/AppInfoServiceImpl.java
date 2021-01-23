package com.xz.cmcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.cmcc.dao.AppInfoDao;
import com.xz.cmcc.entity.AppInfo;
import com.xz.cmcc.service.AppInfoService;


@Service
public class AppInfoServiceImpl implements AppInfoService{

	@Autowired
	private AppInfoDao appInfoDao;
	
	@Override
	public List<AppInfo> getAppInfo() {
		// TODO Auto-generated method stub
		return appInfoDao.queryAppInfo();
	}

}
