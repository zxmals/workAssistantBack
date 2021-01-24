package com.xz.cmcc.dao;

import java.util.List;

import com.xz.cmcc.entity.SoftWearTypeInfo;

public interface SoftWearTypeInfoDao {

	SoftWearTypeInfo querySoftWearTypeInfoById(Integer softwear_type_id);
	
	List<SoftWearTypeInfo> querySoftWearTypeInfo();
}
