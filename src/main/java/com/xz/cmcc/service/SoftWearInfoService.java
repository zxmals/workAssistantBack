package com.xz.cmcc.service;

import java.util.List;

import com.xz.cmcc.entity.SoftWearInfo;

public interface SoftWearInfoService {
	
	List<SoftWearInfo> getSoftWearInfo();
	
	SoftWearInfo getSoftWearInfoById(Integer softWearId);

}
