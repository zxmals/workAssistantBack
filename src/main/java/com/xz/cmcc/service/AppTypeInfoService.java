package com.xz.cmcc.service;

import java.util.List;

import com.xz.cmcc.entity.AppTypeInfo;

public interface AppTypeInfoService{
	
	List<AppTypeInfo> getAppTypeInfo();
	
	AppTypeInfo getAppTypeInfoById(Integer app_type_id);

}
