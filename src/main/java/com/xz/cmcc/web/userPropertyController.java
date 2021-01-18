package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.userProperty;
import com.xz.cmcc.service.userPropertyService;

@RestController
@RequestMapping(value="/workassist")
public class userPropertyController {

	@Autowired
	private userPropertyService userPropservice;
	
	@RequestMapping(value = "/getuserpropbymac", method = RequestMethod.GET)
	private Map<String, Object> getUserPropByMacAddress(String macAddress){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		userProperty userProp = userPropservice.getUserPropertyByMacAddress(macAddress);
		modelMap.put("userprop",userProp);
		return modelMap;
	}
	
	@RequestMapping(value = "/getuserpropbyip", method = RequestMethod.GET)
	private Map<String, Object> getUserPropByIpAddress(String ipAddress){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		userProperty userProp = userPropservice.getUserPropertyByIpAddress(ipAddress);
		modelMap.put("userprop",userProp);
		return modelMap;
	}
}
