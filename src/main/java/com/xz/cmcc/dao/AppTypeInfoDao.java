package com.xz.cmcc.dao;

import java.util.List;

import com.xz.cmcc.entity.AppTypeInfo;

public interface AppTypeInfoDao {

	AppTypeInfo queryAppTypeInfoById(Integer app_type_id);
	
	List<AppTypeInfo> queryAppTypeInfo();
}
