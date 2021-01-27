package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.AppTypeInfo;
import com.xz.cmcc.service.AppTypeInfoService;

@RestController
@RequestMapping(value="/workassist")
public class AppTypeInfoController {

	@Autowired
	private AppTypeInfoService appTypeInfoService;
	
	@RequestMapping(value="/getapptype",method=RequestMethod.GET)
	public Map<String, Object> getAppTypeInfo(){
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<AppTypeInfo> apptypeli = appTypeInfoService.getAppTypeInfo();
		modelmap.put("apptype", apptypeli);
		return modelmap;
	}
}
