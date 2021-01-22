package com.xz.cmcc.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.cmcc.entity.DriverInfo;
import com.xz.cmcc.service.DriverInfoService;

@RestController
@RequestMapping(value="/workassist")
public class DriverInfoController {

	@Autowired
	private DriverInfoService driverInfoService;
	
	@RequestMapping(value="/getdriverinfobycmandos",method=RequestMethod.GET)
	public Map<String, Object> getDriverInfoByCompAndOs(Integer computer_id,Integer os_id){
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<DriverInfo> driverinfoli = driverInfoService.getDriverInfoByComputerAndOs(computer_id, os_id);
		modelmap.put("dirverinfo", driverinfoli);
		return modelmap;
	}
	
	@RequestMapping(value="/driverdownload",method=RequestMethod.GET)
    public String downLoad(HttpServletResponse response,String driver_id) throws UnsupportedEncodingException {
	        String filename= driverInfoService.getDriverInfoById(Integer.parseInt(driver_id)).getDriver_name2();
	        String filePath = driverInfoService.getDriverInfoById(Integer.parseInt(driver_id)).getStore_path();
	        File file = new File(filePath + "/" + filename);
	        System.out.println(filePath + "/" + filename);
	        if(file.exists()){ //判断文件父目录是否存在
	            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	            response.setCharacterEncoding("UTF-8");
	           // response.setContentType("application/force-download");
	            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
	            byte[] buffer = new byte[1024];
	            FileInputStream fis = null; //文件输入流
	            BufferedInputStream bis = null;
	
	            OutputStream os = null; //输出流
	            try {
	                os = response.getOutputStream();
	                fis = new FileInputStream(file);
	                bis = new BufferedInputStream(fis);
	                int i = bis.read(buffer);
	                while(i != -1){
	                    os.write(buffer);
	                    i = bis.read(buffer);
	                }
	
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            System.out.println("----------file download---" + filename);
	            try {
	                bis.close();
	                fis.close();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        return null;
        }
}
