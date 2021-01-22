package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.OperationSystemInfo;
import com.xz.cmcc.service.OperationSystemInfoService;

@RestController
@RequestMapping(value="/workassist")
public class OperationSystemInfoController {

	@Autowired
	private OperationSystemInfoService osInfoService;
	
	@RequestMapping(value="/getosinfo",method=RequestMethod.GET)
	public Map<String, Object> getOsInfo(){
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<OperationSystemInfo> oslist = osInfoService.getOperationSystemInfo();
		modelmap.put("osinfo", oslist);
		return modelmap;
	}
}
