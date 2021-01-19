package com.xz.cmcc.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xz.cmcc.entity.SoftWearInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
class SoftWearInfoDaoTest {

	@Autowired
	private SoftWearInfoDao softWearInfoDao;
	
	@Test
	void testQuerySoftWearInfoById() {
		SoftWearInfo softWearInfo = softWearInfoDao.querySoftWearInfoById(1);
		assertEquals("虾米音乐", softWearInfo.getSoftwear_name1());
		
	}

	@Test
	void testQuerySoftWearInfo() {
		List<SoftWearInfo> sfInfolist = softWearInfoDao.querySoftWearInfo();
		for (int i = 0; i < sfInfolist.size(); i++) {
			System.out.println(sfInfolist.get(i).getSoftwear_id());
			System.out.println(sfInfolist.get(i).getSoftwear_name1());
			System.out.println(sfInfolist.get(i).getSoftwear_name2());
			System.out.println(sfInfolist.get(i).getCategory_name());
			System.out.println(sfInfolist.get(i).getStore_path());
			System.out.println(sfInfolist.get(i).getCreate_date());
		}
		assertEquals(2, sfInfolist.size());
	}

}
