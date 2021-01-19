package com.xz.cmcc.dao;

import java.util.List;

import com.xz.cmcc.entity.SoftWearInfo;

public interface SoftWearInfoDao {
	
	SoftWearInfo querySoftWearInfoById(Integer softwear_id);
	
	List<SoftWearInfo> querySoftWearInfo();

}
