package com.xz.cmcc.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xz.cmcc.entity.AppInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
class AppInfoDaoTest {

	@Autowired
	private AppInfoDao appInfoDao;
	
	@Test
	void testQueryAppInfo() {
		List<AppInfo> appinfoli = appInfoDao.queryAppInfo();
		assertEquals(4, appinfoli.size());
		for (AppInfo appInfo : appinfoli) {
			System.out.print(appInfo.getApp_id()+"  ");
			System.out.print(appInfo.getApp_name()+"  ");
			System.out.print(appInfo.getApp_href()+"  ");
			System.out.print(appInfo.getImg_store_path()+"  ");
			System.out.print(appInfo.getApptypeInfo().getApp_type_id()+"  ");
			System.out.println(appInfo.getApptypeInfo().getApp_type_name()+"  ");
		}
	}

}
