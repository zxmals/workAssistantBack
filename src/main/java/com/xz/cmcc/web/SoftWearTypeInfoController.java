package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.SoftWearTypeInfo;
import com.xz.cmcc.service.SoftWearTypeInfoService;

@RestController
@RequestMapping(value="workassist")
public class SoftWearTypeInfoController {
	
	
	@Autowired
	private SoftWearTypeInfoService softweartypeservice;
	
	@RequestMapping(value="/getsoftweartype")
	public Map<String, Object> getSoftWearTypeInfo(){
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<SoftWearTypeInfo> softweraTypeli = softweartypeservice.getSoftWearTypeInfo();
		modelmap.put("softweartype",softweraTypeli);
		return modelmap;
	}

}
