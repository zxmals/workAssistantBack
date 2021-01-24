package com.xz.cmcc.service;

import java.util.List;

import com.xz.cmcc.entity.SoftWearTypeInfo;

public interface SoftWearTypeInfoService {

	SoftWearTypeInfo getSoftWearTypeById(Integer softwear_type_id);
	
	List<SoftWearTypeInfo> getSoftWearTypeInfo();
}
