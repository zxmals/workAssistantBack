package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.AppInfo;
import com.xz.cmcc.service.AppInfoService;

@RestController
@RequestMapping(value="/workassist")
public class AppInfoController {

	@Autowired
	private AppInfoService appInfoService;
	
	@RequestMapping(value="/getappinfo",method=RequestMethod.GET)
	public Map<String, Object> getAppInfo(){
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<AppInfo> appInfoli = appInfoService.getAppInfo();
		modelmap.put("appinfo", appInfoli);
		return modelmap;
	}
}
