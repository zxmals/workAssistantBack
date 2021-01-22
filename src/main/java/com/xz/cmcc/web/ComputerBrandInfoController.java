package com.xz.cmcc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.ComputerBrandInfo;
import com.xz.cmcc.service.ComputerBrandInfoService;

@RestController
@RequestMapping(value="/workassist")
public class ComputerBrandInfoController {

	@Autowired
	private ComputerBrandInfoService cbrandInfoDao;
	
	@RequestMapping(value="/getcomputerbrand",method=RequestMethod.GET)
	public Map<String, Object> getComputerBrandInfo(){
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<ComputerBrandInfo> cbrandli = cbrandInfoDao.getComputerBrandInfo();
		modelmap.put("brand", cbrandli);
		return modelmap;
	}
}
