package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.SoftWearInfo;
import com.xz.cmcc.service.SoftWearInfoService;

@RestController
@RequestMapping(value="/workassist")
public class SoftWearInfoController {
	
	@Autowired
	private SoftWearInfoService softInfoService;
	
	@RequestMapping(value="/getsoftwear",method=RequestMethod.GET)
	private Map<String, Object> getSoftWearInfo(){
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<SoftWearInfo> softwearlist = softInfoService.getSoftWearInfo();
		modelmap.put("softwear",softwearlist);
		return modelmap;
	}

}
