package com.xz.cmcc.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xz.cmcc.entity.ComputerInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
class ComputerInfoDaoTest {

	@Autowired
	private ComputerInfoDao computerInfoDao;
	
	@Test
	void testQueryComputerInfo() {
		List<ComputerInfo> compinfolist = computerInfoDao.queryComputerInfo();
		assertEquals(24, compinfolist.size());
	}

	@Test
	void testQueryComputerInfoById() {
		ComputerInfo computerinfo = computerInfoDao.queryComputerInfoById(1);
		assertEquals("联想X270", computerinfo.getComputer_name());
		
	}

	@Test
	void testQueryComputerInfoByBrandAndModel() {
		ComputerInfo computerinfo = computerInfoDao.queryComputerInfoByBrandAndModel(2, 1);
		assertEquals("联想X270", computerinfo.getComputer_name());
	}
}
