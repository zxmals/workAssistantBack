package com.xz.cmcc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xz.cmcc.entity.SoftWearTypeInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
class SoftWearTypeInfoDaoTest {

	@Autowired
	private SoftWearTypeInfoDao softWearTypeDao;
	
	@Test
	void testQuerySoftWearTypeInfoById() {
		SoftWearTypeInfo sfti = softWearTypeDao.querySoftWearTypeInfoById(1);
		assertEquals("操作系统", sfti.getSoftwear_type_name());
	}

}
