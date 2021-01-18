package com.xz.cmcc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xz.cmcc.entity.userProperty;

@RunWith(SpringRunner.class)
@SpringBootTest
class userPropertyDaoTest {

	@Autowired
	private userPropertyDao userPropDao;
	
	@Test
	void testQueryUserPropertyByMacAddress() {
		userProperty userprop = userPropDao.queryUserPropertyByMacAddress("AC:E2:D3:6C:D1:0D");
		assertEquals("47001945", userprop.getUser_id());
	}

	@Test	
	void testQueryUserPropertyByIpAddress() {
		userProperty userprop = userPropDao.queryUserPropertyByIpAddress("10.234.183.175");
		assertEquals("47001945", userprop.getUser_id());
	}

}
