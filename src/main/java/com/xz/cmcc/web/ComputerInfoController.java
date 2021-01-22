package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.ComputerInfo;
import com.xz.cmcc.service.ComputerInfoService;


@RestController
@RequestMapping(value="/workassist")
public class ComputerInfoController {

	@Autowired
	private ComputerInfoService computerInfoService;	
	
	@RequestMapping(value="/getcomputerinfo",method=RequestMethod.GET)
	public Map<String, Object> getComputerInfo(){
		Map<String, Object> mapmodel = new HashMap<String, Object>();
		List<ComputerInfo> computerinfoli = computerInfoService.getComputerInfo();
		mapmodel.put("computerinfo", computerinfoli);
		return mapmodel;
	}	
}
