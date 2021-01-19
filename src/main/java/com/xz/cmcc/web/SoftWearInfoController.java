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

	@RequestMapping(value="/download",method=RequestMethod.GET)
    public String downLoad(HttpServletResponse response,int softwear_id) throws UnsupportedEncodingException {
	        String filename= softInfoService.getSoftWearInfoById(softwear_id).getSoftwear_name2();
	        String filePath = softInfoService.getSoftWearInfoById(softwear_id).getStore_path();
	        File file = new File(filePath + "/" + filename);
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
