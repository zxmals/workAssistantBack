package com.xz.cmcc.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xz.cmcc.entity.DriverInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
class DriverInfoDaoTest {

	@Autowired
	private DriverInfoDao driverInfoDao;
	
	@Test
	void testQueryDriverInfoByComputerAndOs() {
		List<DriverInfo> driverinfoli = driverInfoDao.queryDriverInfoByComputerAndOs(2, 1);
		for (DriverInfo driverInfo : driverinfoli) {
			System.out.print(driverInfo.getDriver_id()+"  ");
			System.out.print(driverInfo.getDriver_name1()+"  ");
			System.out.print(driverInfo.getDriver_name2()+"  ");
			System.out.print(driverInfo.getStore_path()+"  ");
			System.out.print(driverInfo.getCreate_date()+"  ");
			System.out.print(driverInfo.getComputerinfo().getComputer_name()+"  ");
			System.out.print(driverInfo.getComputerinfo().getComputerbrand().getPc_brand_name()+"  ");			
			System.out.print(driverInfo.getComputerinfo().getComputermodel().getPc_model_name()+"  ");
			System.out.println(driverInfo.getOsinfo().getOperation_system_name());
		}
		assertEquals(1, driverinfoli.size());
	}

	@Test
	void testQueryDriverInfoById() {
		DriverInfo driverInfo = driverInfoDao.queryDriverInfoById(1);
		assertEquals("AMD独立显卡驱动", driverInfo.getDriver_name1());
	}

}
