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
	private SoftWearInfoDao softwfDao;
	
	@Test
	void testQuerySoftWearInfoById() {
		List<SoftWearInfo> softwearli = softwfDao.querySoftWearInfo();
		System.out.println(softwearli.size());
		for (SoftWearInfo softWearInfo : softwearli) {
			System.out.print(softWearInfo.getSoftwear_id()+"  ");
			System.out.print(softWearInfo.getSoftwear_name1()+"  ");
			System.out.print(softWearInfo.getSoftwear_name2()+"  ");
			System.out.print(softWearInfo.getStore_path()+"  ");
			System.out.print(softWearInfo.getSoftWearTypeInfo().getSoftwear_type_id()+"  ");
			System.out.println(softWearInfo.getSoftWearTypeInfo().getSoftwear_type_name()+"  ");
		}
	}

	@Test
	void testQuerySoftWearInfo() {
		SoftWearInfo softWearInfo = softwfDao.querySoftWearInfoById(1);
		System.out.println(softWearInfo.getSoftwear_id());
		System.out.println(softWearInfo.getSoftwear_name1());
		System.out.println(softWearInfo.getSoftwear_name2());
		System.out.println(softWearInfo.getSoftWearTypeInfo().getSoftwear_type_name());
	}

}
